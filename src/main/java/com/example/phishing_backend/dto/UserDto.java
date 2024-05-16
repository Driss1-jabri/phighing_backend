package com.example.phishing_backend.dto;

import java.util.List;

public record UserDto(
        Long id,
        String username,
        String email,
        List<Long> emailIds,
         List<Long> alertIds

) {
}
