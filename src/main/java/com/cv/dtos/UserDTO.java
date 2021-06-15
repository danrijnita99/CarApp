package com.cv.dtos;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class UserDTO {
    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @Email
    private String email;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotNull
    private Boolean active;
}
