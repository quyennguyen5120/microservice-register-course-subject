package com.example.domain.repository;

import com.example.domain.model.SmtSbjModel;

import java.util.List;

public interface SmtSbjRepository {
    List<SmtSbjModel> getAll();
    SmtSbjModel findById(int smtSbjId);
    Integer createSmtSbj(SmtSbjModel smtSbjModel);
    Integer updateSmtSbj(SmtSbjModel smtSbjModel);
    String registerSubject(int smtSbjId);
    void setBucket(int smtSbjId, int slot);
    Object getBucket(int smtSbjId);
}
