package com.example.myapp.model.request;

import com.example.myapp.enums.Roles;
import lombok.Data;

@Data
public class JwtRequest {
    private String email;
    private String username;
    private String password;
    private Roles role;
}
