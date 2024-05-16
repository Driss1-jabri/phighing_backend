package com.example.phishing_backend.repositories;


import com.example.phishing_backend.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UrlRepository extends JpaRepository<Url, Long> {
    List<Url> findByEmailId(Long emailId);
}
