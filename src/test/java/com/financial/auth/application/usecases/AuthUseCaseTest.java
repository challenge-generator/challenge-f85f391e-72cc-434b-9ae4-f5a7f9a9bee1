package com.financial.auth.application.usecases;

import com.financial.auth.domain.model.User;
import com.financial.auth.domain.ports.AuthServicePort;
import com.financial.auth.domain.ports.UserRepositoryPort;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Disabled("Superficie de práctica - implementar casos de prueba")
class AuthUseCaseTest {

    @InjectMocks
    private AuthUseCase authUseCase;

    @Mock
    private UserRepositoryPort userRepository;

    @Mock
    private AuthServicePort authService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void shouldAuthenticateSuccessfullyWithValidCredentials() {
        User user = new User(
            UUID.randomUUID(),
            "testuser",
            "test@example.com",
            "encodedPassword",
            "USER"
        );
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("password123", "encodedPassword")).thenReturn(true);
        when(authService.generateToken(user)).thenReturn("jwt-token");

        User result = authUseCase.authenticate("testuser", "password123");

        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
        verify(authService).generateToken(user);
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {
        when(userRepository.findByUsername("nonexistent")).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->
            authUseCase.authenticate("nonexistent", "password123")
        );
    }

    @Test
    void shouldThrowExceptionWhenPasswordIsIncorrect() {
        User user = new User(
            UUID.randomUUID(),
            "testuser",
            "test@example.com",
            "encodedPassword",
            "USER"
        );
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("wrongpassword", "encodedPassword")).thenReturn(false);

        assertThrows(RuntimeException.class, () ->
            authUseCase.authenticate("testuser", "wrongpassword")
        );
    }

    @Test
    void shouldRegisterNewUserSuccessfully() {
        when(userRepository.findByUsername("newuser")).thenReturn(Optional.empty());
        when(userRepository.findByEmail("new@example.com")).thenReturn(Optional.empty());
        when(passwordEncoder.encode("password123")).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(authService.generateToken(any(User.class))).thenReturn("jwt-token");

        User result = authUseCase.register("newuser", "new@example.com", "password123");

        assertNotNull(result);
        assertEquals("newuser", result.getUsername());
        verify(userRepository).save(any(User.class));
    }

    @Test
    void shouldThrowExceptionWhenUsernameAlreadyExists() {
        User existingUser = new User(
            UUID.randomUUID(),
            "existinguser",
            "existing@example.com",
            "encodedPassword",
            "USER"
        );
        when(userRepository.findByUsername("existinguser")).thenReturn(Optional.of(existingUser));

        assertThrows(RuntimeException.class, () ->
            authUseCase.register("existinguser", "new@example.com", "password123")
        );
    }

    @Test
    void shouldValidateTokenSuccessfully() {
        User user = new User(
            UUID.randomUUID(),
            "testuser",
            "test@example.com",
            "encodedPassword",
            "USER"
        );
        when(authService.validateToken("valid-token")).thenReturn(Optional.of(user));

        Optional<User> result = authUseCase.validateToken("valid-token");

        assertTrue(result.isPresent());
        assertEquals("testuser", result.get().getUsername());
    }

    @Test
    void shouldReturnEmptyWhenTokenIsInvalid() {
        when(authService.validateToken("invalid-token")).thenReturn(Optional.empty());

        Optional<User> result = authUseCase.validateToken("invalid-token");

        assertTrue(result.isEmpty());
    }
}