package com.example.phishing_backend.entities;




import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private LocalDateTime timestamp;
    private boolean isRead;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // getters and setters
}

