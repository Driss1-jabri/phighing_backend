package com.example.phishing_backend.service;

import com.example.phishing_backend.entities.Email;

import java.util.List;
import java.util.Optional;

public interface EmailService {

    Optional<Boolean> addEmail(Email email);
    Optional<List<Email>> getEmailsByUser(String email);
    Optional<Email> getEmailById(Long id);



}
