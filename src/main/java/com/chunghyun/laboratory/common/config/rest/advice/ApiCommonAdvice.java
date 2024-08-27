package com.chunghyun.laboratory.common.config.rest.advice;

import com.chunghyun.laboratory.common.exception.ApiErrorException;
import com.chunghyun.laboratory.common.exception.ErrorCode;
import com.chunghyun.laboratory.common.exception.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
public class ApiCommonAdvice {

    private final MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerException(Exception e) {
        System.out.println("에러 핸들러 = " + e);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ApiErrorException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(ApiErrorException e) {

        ErrorResponse response = null;
        if (e.getErrorCode() != null) {
            response = new ErrorResponse(e.getErrorCode(), e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.valueOf(e.getErrorCode().getStatusCode()));
        }

        var errorCode = ErrorCode.SERVER_ERROR;

        response = new ErrorResponse(errorCode, e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatusCode()));
    }
}
