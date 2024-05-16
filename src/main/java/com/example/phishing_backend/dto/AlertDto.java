package com.example.phishing_backend.dto;

import java.time.LocalDateTime;

public record AlertDto (
        Long id,
        String message,
        LocalDateTime timestamp,
     boolean isRead,
     Long userId
    ){}
