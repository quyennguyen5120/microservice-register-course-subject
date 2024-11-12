package com.example.application.service.smtsbj.smtsbjImpl;

import com.example.application.service.smtsbj.SmtSbjService;
import com.example.domain.model.SmtSbjModel;
import com.example.domain.repository.SmtSbjRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SmtSbjServiceImpl implements SmtSbjService {
    private final SmtSbjRepository smtSbjRepository;

    @Override
    public List<SmtSbjModel> getAll() {
        return smtSbjRepository.getAll();
    }

    @Override
    public SmtSbjModel findById(int smtSbjId) {
        return smtSbjRepository.findById(smtSbjId);
    }

    @Override
    public Integer createSmtSbj(SmtSbjModel smtSbjModel) {
        return smtSbjRepository.createSmtSbj(smtSbjModel);
    }

    @Override
    public Integer updateSmtSbj(SmtSbjModel smtSbjModel) {
        return smtSbjRepository.updateSmtSbj(smtSbjModel);
    }

    @Override
    public String registerSubject(int smtSbjId) {
        return smtSbjRepository.registerSubject(smtSbjId);
    }

    @Override
    public void setBucket(int smtSbjId, int slot) {
        smtSbjRepository.setBucket(smtSbjId, slot);
    }

    @Override
    public Object getBucket(int smtSbjId) {
        Object bucket = smtSbjRepository.getBucket(smtSbjId);
        return bucket;
    }
}
