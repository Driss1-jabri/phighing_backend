package com.example.phishing_backend.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalUrl;
    private boolean isSafe;




}
