package com.cv.exceptions;

public class UserAlreadyExistingException extends Exception {
    public UserAlreadyExistingException() {
        super("This user already exists ");
    }
}
