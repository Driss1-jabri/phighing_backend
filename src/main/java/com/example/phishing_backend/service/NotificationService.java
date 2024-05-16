package com.example.phishing_backend.service;

import com.example.phishing_backend.entities.Validation;

public interface NotificationService {
    public void envoyerEmailVerificationUser(Validation validation);
}
