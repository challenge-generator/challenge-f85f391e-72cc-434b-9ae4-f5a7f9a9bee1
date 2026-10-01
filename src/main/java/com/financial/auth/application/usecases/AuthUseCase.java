package com.financial.auth.application.usecases;

import com.financial.auth.domain.model.User;
import com.financial.auth.domain.ports.AuthServicePort;
import com.financial.auth.domain.ports.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthUseCase {

    private final AuthServicePort authServicePort;
    private final UserRepositoryPort userRepositoryPort;

    public Optional<String> authenticate(String username, String password) {
        return Optional.empty();
    }

    public Optional<User> validateToken(String token) {
        return Optional.empty();
    }

    public User register(String username, String email, String password, String role) {
        return null;
    }
}