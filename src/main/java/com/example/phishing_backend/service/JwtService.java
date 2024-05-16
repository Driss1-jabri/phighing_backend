package com.example.phishing_backend.service;

import com.example.phishing_backend.dto.AuthenticationDTO;
import com.example.phishing_backend.exceptions.RefreshTokenExpiredException;

import java.util.Map;

public interface JwtService {
    public Map<String,String> generateToken(AuthenticationDTO authenticationDTO) throws RefreshTokenExpiredException;
}
