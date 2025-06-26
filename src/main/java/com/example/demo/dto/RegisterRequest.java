package com.example.demo.dto;
import com.example.demo.model.Role;
import lombok.Data;

// RegisterRequest.java
@Data
public class RegisterRequest {
    private String username;
    private String password;
    private Role role;
}