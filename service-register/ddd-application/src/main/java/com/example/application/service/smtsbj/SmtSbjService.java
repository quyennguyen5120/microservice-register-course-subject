package com.example.application.service.smtsbj;

import com.example.domain.model.SmtSbjModel;

import java.util.List;

public interface SmtSbjService {
    List<SmtSbjModel> getAll();
    SmtSbjModel findById(int smtSbjId);
    Integer createSmtSbj(SmtSbjModel smtSbjModel);
    Integer updateSmtSbj(SmtSbjModel smtSbjModel);
    String registerSubject(int smtSbjId);
    void setBucket(int smtSbjId,int slot);
    Object getBucket(int smtSbjId);
}
