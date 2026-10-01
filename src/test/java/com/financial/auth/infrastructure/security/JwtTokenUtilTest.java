package com.financial.auth.infrastructure.security;

import com.financial.auth.domain.model.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Disabled("Superficie de práctica - implementar casos de prueba")
class JwtTokenUtilTest {

    @InjectMocks
    private JwtTokenUtil jwtTokenUtil;

    @Mock
    private User mockUser;

    @Test
    void shouldGenerateTokenWithCorrectClaims() {
        UUID userId = UUID.randomUUID();
        when(mockUser.getId()).thenReturn(userId);
        when(mockUser.getUsername()).thenReturn("testuser");
        when(mockUser.getRole()).thenReturn("USER");

        String token = jwtTokenUtil.generateToken(mockUser);

        assertNotNull(token);
        assertFalse(token.isEmpty());
    }

    @Test
    void shouldExtractUsernameFromToken() {
        UUID userId = UUID.randomUUID();
        when(mockUser.getId()).thenReturn(userId);
        when(mockUser.getUsername()).thenReturn("testuser");
        when(mockUser.getRole()).thenReturn("USER");

        String token = jwtTokenUtil.generateToken(mockUser);
        String extractedUsername = jwtTokenUtil.extractUsername(token);

        assertEquals("testuser", extractedUsername);
    }

    @Test
    void shouldExtractUserIdFromToken() {
        UUID userId = UUID.randomUUID();
        when(mockUser.getId()).thenReturn(userId);
        when(mockUser.getUsername()).thenReturn("testuser");
        when(mockUser.getRole()).thenReturn("USER");

        String token = jwtTokenUtil.generateToken(mockUser);
        UUID extractedUserId = jwtTokenUtil.extractUserId(token);

        assertEquals(userId, extractedUserId);
    }

    @Test
    void shouldReturnTrueForValidToken() {
        UUID userId = UUID.randomUUID();
        when(mockUser.getId()).thenReturn(userId);
        when(mockUser.getUsername()).thenReturn("testuser");
        when(mockUser.getRole()).thenReturn("USER");

        String token = jwtTokenUtil.generateToken(mockUser);
        boolean isValid = jwtTokenUtil.validateToken(token, mockUser);

        assertTrue(isValid);
    }

    @Test
    void shouldReturnFalseForInvalidToken() {
        when(mockUser.getId()).thenReturn(UUID.randomUUID());
        when(mockUser.getUsername()).thenReturn("testuser");
        when(mockUser.getRole()).thenReturn("USER");

        boolean isValid = jwtTokenUtil.validateToken("invalid.token.here", mockUser);

        assertFalse(isValid);
    }

    @Test
    void shouldReturnFalseForExpiredToken() {
        // TODO: Implementar test de token expirado
        // Pista: configurar JwtTokenUtil con clock skew o manipular el tiempo
    }

    @Test
    void shouldExtractRoleFromToken() {
        UUID userId = UUID.randomUUID();
        when(mockUser.getId()).thenReturn(userId);
        when(mockUser.getUsername()).thenReturn("testuser");
        when(mockUser.getRole()).thenReturn("ADMIN");

        String token = jwtTokenUtil.generateToken(mockUser);
        String role = jwtTokenUtil.extractRole(token);

        assertEquals("ADMIN", role);
    }
}