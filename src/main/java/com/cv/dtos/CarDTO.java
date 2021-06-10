package com.cv.dtos;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDTO {
    private String brand;
    private String model;
    private Integer price;
    private Boolean available;
}