package com.example.phishing_backend.service.serviceImpl;

import com.example.phishing_backend.entities.Email;
import com.example.phishing_backend.service.EmailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmailServiceImp implements EmailService {
    @Override
    public Optional<Boolean> addEmail(Email email) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Email>> getEmailsByUser(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<Email> getEmailById(Long id) {
        return Optional.empty();
    }
}
