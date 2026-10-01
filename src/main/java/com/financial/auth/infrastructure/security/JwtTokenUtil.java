package com.financial.auth.infrastructure.security;

import com.financial.auth.domain.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;

@Component
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration:3600000}")
    private Long expiration;

    public String generateToken(User user) {
        return null;
    }

    public Optional<Claims> validateToken(String token) {
        return Optional.empty();
    }

    public String getUsernameFromToken(String token) {
        return null;
    }

    public String getRoleFromToken(String token) {
        return null;
    }

    public boolean isTokenExpired(String token) {
        return true;
    }

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    private Claims extractAllClaims(String token) {
        return null;
    }
}