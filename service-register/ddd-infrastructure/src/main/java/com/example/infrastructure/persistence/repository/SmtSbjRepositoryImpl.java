package com.example.infrastructure.persistence.repository;

import com.example.domain.common.CommonException;
import com.example.domain.common.ErrorCode;
import com.example.domain.model.SmtSbjModel;
import com.example.domain.repository.SmtSbjRepository;
import com.example.infrastructure.persistence.mapper.SmtSbjMapper;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
@RequiredArgsConstructor
@Transactional
public class SmtSbjRepositoryImpl implements SmtSbjRepository {
    private final SmtSbjMapper smtSbjMapper;
    private final RedissonClient redissonClient;
    @Value("${resilience4j.circuitbreaker.instances.backendA.failureRateThreshold}")
    private int failureRateThreshold;

    @Override
    public List<SmtSbjModel> getAll() {
        return smtSbjMapper.getAll();
    }

    @Override
    public SmtSbjModel findById(int smtSbjId) {
        SmtSbjModel rs = smtSbjMapper.findById(smtSbjId);
        return rs;
    }

    @Override
    public Integer createSmtSbj(SmtSbjModel smtSbjModel) {
        smtSbjMapper.createSmtSbj(smtSbjModel);
        redissonClient.getAtomicLong("subject-" + smtSbjModel.getSmtSbjId() + "-slot").set(smtSbjModel.getSlot());
        return smtSbjModel.getSmtSbjId();
    }

    @Override
    public Integer updateSmtSbj(SmtSbjModel smtSbjModel) {
        smtSbjMapper.updateSmtSbj(smtSbjModel);
        redissonClient.getAtomicLong("subject-" + smtSbjModel.getSmtSbjId() + "-slot").set(smtSbjModel.getSlot());
        return smtSbjModel.getSmtSbjId();
    }

    public String handleException(CallNotPermittedException ex) {
        throw new CommonException(ErrorCode.CIRCUITBREAKER_FULLY_REGISTERED);
    }

    @Override//Redis
    @CircuitBreaker(name = "backendB", fallbackMethod = "handleException")
    public String registerSubject(int smtSbjId) {
        String lockKey = "subject-lock-" + smtSbjId;
        RLock lock = redissonClient.getLock(lockKey);

        try {
            if (lock.tryLock(100, 5, TimeUnit.SECONDS)) {
                try {
                    RAtomicLong rs = redissonClient.getAtomicLong("subject-" + smtSbjId + "-slot");

                    if (!rs.isExists()) {
                        throw new CommonException(ErrorCode.NOT_FOUND);
                    }

                    if (rs.get() <= 0) {
                        throw new CommonException(ErrorCode.FULLY_REGISTERED);
                    }

                    smtSbjMapper.registerSmtSbj(smtSbjId);
                    rs.decrementAndGet();

                    return "Registered successfully";
                } finally {
                    lock.unlock();
                }
            } else {
                throw new CommonException(ErrorCode.GET_LOCK_ERR);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
            throw new CommonException(ErrorCode.GET_LOCK_ERR);
        }
    }

    @Override
    public void setBucket(int smtSbjId, int slot) {
        redissonClient.getBucket("subject-" + smtSbjId + "-slot").set(slot);
    }

    @Override
    public Object getBucket(int smtSbjId) {
        Object rs = redissonClient.getBucket("subject-"+smtSbjId+"-slot").get();
        if(rs == null){
            Integer slot = smtSbjMapper.findSlotById(smtSbjId);
            if(slot == null)
                return "Subject not found";
            redissonClient.getBucket("subject-" + smtSbjId + "-slot").set(slot);
            return slot;
        }
        return rs;
    }
}
