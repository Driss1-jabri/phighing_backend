package com.example.phishing_backend.repositories;

import com.example.phishing_backend.entities.RoleApp;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository<RoleApp, Long> {
}
