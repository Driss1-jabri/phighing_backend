package com.example.phishing_backend.entities;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String sender;
    @Lob
    private String body;
    private boolean isPhishing;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
