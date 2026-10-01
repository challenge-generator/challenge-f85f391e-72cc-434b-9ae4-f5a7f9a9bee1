package com.financial.auth.infrastructure.adapters;

import com.financial.auth.domain.model.User;
import com.financial.auth.domain.ports.AuthServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceAdapter implements AuthServicePort {

    @Override
    public String generateToken(User user) {
        return null;
    }

    @Override
    public Optional<User> validateToken(String token) {
        return Optional.empty();
    }
}