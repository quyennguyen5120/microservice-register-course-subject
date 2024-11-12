package com.example.domain.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private int statusCode;
    private String responseMessage;
    private String code;

    public ErrorResponse(ErrorCode errorCode) {
        this.statusCode = errorCode.getStatus();
        this.responseMessage = errorCode.getMessage();
        this.code = errorCode.getErrorCode();
    }
}
