package com.financial.auth.domain.ports;

import com.financial.auth.domain.model.User;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {
    Optional<User> findByUsername(String username);
    
    Optional<User> findByEmail(String email);
    
    User save(User user);
    
    Optional<User> findById(UUID id);
}