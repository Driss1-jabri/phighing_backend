package com.example.phishing_backend.dto;

public record AuthenticationDTO(
        String username,
        String password,
        boolean withRefreshToken,
        String refreshToken,
        String grantType
) {}