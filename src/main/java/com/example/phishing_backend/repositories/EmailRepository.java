package com.example.phishing_backend.repositories;


import com.example.phishing_backend.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailRepository extends JpaRepository<Email, Long> {
    List<Email> findByUserId(Long userId);
}
