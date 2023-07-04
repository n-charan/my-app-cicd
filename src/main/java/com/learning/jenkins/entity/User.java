package com.learning.jenkins.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String city;

    private String country;
}
