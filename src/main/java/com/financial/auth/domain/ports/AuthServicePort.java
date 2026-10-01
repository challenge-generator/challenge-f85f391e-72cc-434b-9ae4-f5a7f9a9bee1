package com.financial.auth.domain.ports;

import com.financial.auth.domain.model.User;
import java.util.Optional;

public interface AuthServicePort {
    String generateToken(User user);
    
    Optional<User> validateToken(String token);
}