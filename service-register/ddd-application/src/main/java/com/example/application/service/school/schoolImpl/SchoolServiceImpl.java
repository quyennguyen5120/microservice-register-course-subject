package com.example.application.service.school.schoolImpl;

import com.example.application.service.school.SchoolService;
import com.example.domain.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {
    private final SchoolRepository schoolRepository;

    @Override
    public List<Object> test() {
        return schoolRepository.test();
    }
}
