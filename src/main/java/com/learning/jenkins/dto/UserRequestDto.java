package com.learning.jenkins.dto;

import lombok.Data;

@Data
public class UserRequestDto {

    private String firstName;

    private String lastName;

    private String email;

    private String city;

    private String country;
}
