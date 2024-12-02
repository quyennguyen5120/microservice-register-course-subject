package com.example.service.infrastructure.persistence.repository;

import com.example.service.domain.repository.SchoolRepository;
import com.example.service.infrastructure.persistence.mapper.SchoolMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SchoolRepositoryImpl implements SchoolRepository {
    private final SchoolMapper schoolMapper;

    public List<Object> test() {
        List<Object> lst = schoolMapper.test();
        return lst;
    }
}
