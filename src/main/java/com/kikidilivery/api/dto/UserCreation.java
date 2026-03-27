package com.kikidilivery.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserCreation {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    private String role; // SENDER, DRIVER, ADMIN

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}