package com.chunghyun.laboratory.common.exception;

public class ErrorResponse {
    private final int statusCode;
    private final ErrorMessage error;

    public ErrorResponse(ErrorCode errorCode){
        this.statusCode = errorCode.getStatusCode();
        this.error = new ErrorMessage(
                errorCode.getCategory().name(),
                errorCode.name(),
                errorCode.getMessage()
        );
    }

    public ErrorResponse(ErrorCode errorCode, String message){
        this.statusCode = errorCode.getStatusCode();
        this.error = new ErrorMessage(
                errorCode.getCategory().name(),
                errorCode.name(),
                message
        );
    }

    private record ErrorMessage(
            String category,
            String errorCode,
            String message) {}
}
