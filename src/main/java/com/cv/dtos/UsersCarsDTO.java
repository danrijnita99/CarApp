package com.cv.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UsersCarsDTO {
    @NotNull
    private Long userId;
    @NotNull
    private Long carId;
}
