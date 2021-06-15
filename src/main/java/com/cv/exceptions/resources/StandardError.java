package com.cv.exceptions.resources;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class StandardError {
    private String errorMessage;
    private HttpStatus httpStatus;
}
