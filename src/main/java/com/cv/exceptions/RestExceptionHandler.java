package com.cv.exceptions;

import com.cv.exceptions.resources.StandardError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<?> handleKnownExceptions(GeneralException exception) {
        StandardError standardError = StandardError.builder()
                .errorMessage(exception.getMessage())
                .httpStatus(exception.getHttpStatus())
                .build();

        return new ResponseEntity<>(standardError, exception.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleOtherExceptions(Exception exception) {
        log.info("Something unexpected happened {}", exception.getMessage(), exception);
        StandardError standardError = StandardError.builder()
                .errorMessage(exception.getMessage())
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();

        return new ResponseEntity<>(standardError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
