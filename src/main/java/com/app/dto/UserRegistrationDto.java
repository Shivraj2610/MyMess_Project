package com.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegistrationDto {
    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid Email format")
    @NotBlank(message = "Email is Required")
    private String email;

    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;


    public UserRegistrationDto(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail( String email) {
        this.email = email;
    }

    public  String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public  String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
