package com.cv.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper=false)
public class GeneralException extends Exception {
    private HttpStatus httpStatus;

    public GeneralException(HttpStatus httpStatus, String message) {
        super(message);

        this.httpStatus = httpStatus;
    }
}
