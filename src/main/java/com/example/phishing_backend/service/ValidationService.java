package com.example.phishing_backend.service;


import com.example.phishing_backend.entities.User;
import com.example.phishing_backend.entities.Validation;

public interface ValidationService {
    public Validation addNewValidation(User userApp);
    public Validation getValidationBuCode(String code);
}
