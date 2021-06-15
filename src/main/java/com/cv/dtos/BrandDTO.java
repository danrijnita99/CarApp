package com.cv.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BrandDTO {
    @NotEmpty
    private String name;
}
