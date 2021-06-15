package com.cv.exceptions;

import org.springframework.http.HttpStatus;

public class UserDoesNotExistException extends GeneralException {
    public UserDoesNotExistException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
