package com.example.phishing_backend.dto;

public record EmailDto(
         Long id,
         String subject,
         String sender,
         String body,
         boolean isPhishing,
         Long userID
) {
}
