package com.example.infrastructure.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchoolMapper {
    List<Object> test();
}
