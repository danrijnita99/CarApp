package com.cv.exceptions;

public class CarDoesNotExistException extends Exception{
    public CarDoesNotExistException () {
        super("The car searched does not exist");
    }
}
