package com.financial.auth.domain.model;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class User {
    private UUID id;
    private String username;
    private String email;
    private String password;
    private String role;
    
    public User(UUID id, String username, String email, String password, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}