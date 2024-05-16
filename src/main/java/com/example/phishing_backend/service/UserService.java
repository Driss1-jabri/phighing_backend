package com.example.phishing_backend.service;

import com.example.phishing_backend.dto.AuthenticationDTO;
import com.example.phishing_backend.entities.User;
import com.example.phishing_backend.exceptions.ActivationException;
import com.example.phishing_backend.exceptions.RefreshTokenExpiredException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Map;

public interface UserService extends UserDetailsService {
    public User registerUser(User userApp);
    public void activationAccount(Map<String, String> code) throws ActivationException;
    public Map <String,String> connexion(AuthenticationDTO authenticationDTO) throws RefreshTokenExpiredException;
}
