package com.kikidilivery.api.dto;

import jakarta.validation.constraints.Email;

public class UserUpdate {

    private String name;

    @Email
    private String email;

    private String role;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}