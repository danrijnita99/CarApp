package com.cv.exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends GeneralException {
    public UserAlreadyExistsException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}
