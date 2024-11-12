package com.example.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    //REDIS
    GET_LOCK_ERR(StatusCode.BAD_REQUEST, "RD-ERR-400", "Get lock error."),
    //API
    NOT_FOUND(StatusCode.NOT_FOUND, "COMMON-ERR-404", "Not found."),
    FULLY_REGISTERED(StatusCode.BAD_REQUEST, "SUBJECT-ERR-400", "The course is fully registered."),
    ;
    private int status;
    private String errorCode;
    private String message;
}
