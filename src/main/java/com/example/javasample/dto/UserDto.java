package com.example.javasample.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class UserDto {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String password;
    private String matchingPassword;

    @NotNull
    private String email;
}
