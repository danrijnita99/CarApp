package com.cv.dtos;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class CarDTO {
    @NotEmpty
    private String brand;

    @NotEmpty
    private String model;

    @NotNull
    private Integer price;

    @NotNull
    private Boolean available;
}