package com.cv.exceptions;

public class UserDoesNotExistException extends Exception {
    public UserDoesNotExistException() {
        super("This user does not exist ");
    }
}
