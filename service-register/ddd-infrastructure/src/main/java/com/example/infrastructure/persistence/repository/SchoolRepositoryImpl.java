package com.example.infrastructure.persistence.repository;

import com.example.domain.repository.SchoolRepository;
import com.example.infrastructure.persistence.mapper.SchoolMapper;
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
