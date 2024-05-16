package com.example.phishing_backend.service;

import com.example.phishing_backend.entities.Alert;

import java.util.List;
import java.util.Optional;

public interface AlertService{


    Optional<List<Alert>> getalertsByemail(String email);
    Optional<Alert> sendAlert(String num);
    Optional<Alert> getAlertById(Long id);
    Optional<Boolean> saveAlert(Alert alert);

}
