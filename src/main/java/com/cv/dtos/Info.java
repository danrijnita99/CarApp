package com.cv.dtos;

import lombok.Data;


@Data
public class Info {
    private Long userId;
    private Long id;
    private String title;
    private String body;

    public Info() {

    }
}
