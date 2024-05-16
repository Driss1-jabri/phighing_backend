package com.example.phishing_backend.service.serviceImpl;

import com.example.phishing_backend.entities.Alert;
import com.example.phishing_backend.service.AlertService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertServiceImp implements AlertService {


    //NBQMV8F2ZL5X61ANTAMVM35W recovery code

//    @Value("${TWILIO_ACCOUNT_SID}")
//    String ACCOUNT_SID;
//
//
//    @Value("${TWILIO_AUTH_TOKEN}")
//    String AUTH_TOKEN;
//
//    @Value("${TWILIO_OUTGOING_SMS_NUMBER}")
//    String OUTGOING_SMS_NUMBER;

    @Override
    public Optional<List<Alert>> getalertsByemail(String email) {
        return Optional.empty();
    }


    @Override
    public Optional<Alert> sendAlert(String num) {
        return Optional.empty();
    }

    @Override
    public Optional<Alert> getAlertById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> saveAlert(Alert alert) {
        return Optional.empty();
    }
}
