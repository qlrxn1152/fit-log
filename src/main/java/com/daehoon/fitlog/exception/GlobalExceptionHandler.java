package com.daehoon.fitlog.exception;

import com.daehoon.fitlog.exception.member.NotFoundUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<ErrorResponse> NotFoundUserExceptionHandler(NotFoundUserException e) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());

        return ResponseEntity
                .status(errorResponse.getCode())
                .body(errorResponse);
    }


}
