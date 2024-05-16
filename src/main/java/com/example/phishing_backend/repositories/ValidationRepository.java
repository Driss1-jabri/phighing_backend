package com.example.phishing_backend.repositories;

import com.example.phishing_backend.entities.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationRepository extends JpaRepository<Validation, Long> {
    Validation findValidationByCode(String code);
}
