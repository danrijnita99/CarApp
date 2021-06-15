package com.cv.exceptions;

import org.springframework.http.HttpStatus;

public class CarDoesNotExistException extends GeneralException{
    public CarDoesNotExistException (String message) {
        super(HttpStatus.CONFLICT, message);
    }
}
