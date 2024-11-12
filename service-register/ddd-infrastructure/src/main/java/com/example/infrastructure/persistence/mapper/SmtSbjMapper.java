package com.example.infrastructure.persistence.mapper;

import com.example.domain.model.SmtSbjModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SmtSbjMapper {
    List<SmtSbjModel> getAll();
    SmtSbjModel findById(int smtSbjId);
    void createSmtSbj(SmtSbjModel model);
    void updateSmtSbj(SmtSbjModel model);
    void registerSmtSbj(int smtSbjId);
    Integer findSlotById(int smtSbjId);
}
