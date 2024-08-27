package com.chunghyun.laboratory.common.exception;

import static com.chunghyun.laboratory.common.exception.ErrorCategory.INTERNAL_SERVER_ERROR;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    SERVER_ERROR(500, INTERNAL_SERVER_ERROR, "laboratory.error.server_error");

    private final int statusCode;
    private final ErrorCategory category;
    private final String message;
}
