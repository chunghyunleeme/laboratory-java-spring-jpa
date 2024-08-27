package com.chunghyun.laboratory.common.exception;

import lombok.Getter;

@Getter
public class ApiErrorException extends RuntimeException {

    private final ErrorCode errorCode;
    private final Object[] args;

    public ApiErrorException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.args = null;
    }

    public ApiErrorException(ErrorCode errorCode, Object... args) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.args = args;
    }

    public ApiErrorException(String message) {
        super(message);
        this.errorCode = null;
        this.args = null;
    }
}
