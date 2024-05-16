package com.example.phishing_backend.service.serviceImpl;

import com.example.phishing_backend.entities.User;
import com.example.phishing_backend.entities.Validation;
import com.example.phishing_backend.repositories.ValidationRepository;
import com.example.phishing_backend.service.NotificationService;
import com.example.phishing_backend.service.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@AllArgsConstructor
@Service
public class ValidationServiceImpl  implements ValidationService {
    private final ValidationRepository validationRepository;
    private final NotificationService notificationService;

    @Override
    public Validation addNewValidation(User userApp) {
        Validation validation = new Validation();
        validation.setUserApp(userApp);
        validation.setCreatedAt(Instant.now());
        validation.setExpireAt(validation.getCreatedAt().plus(2, ChronoUnit.MINUTES));
        Random random = new Random();
        int r=random.nextInt(999999);
        String code = String.format("%06d",r);
        validation.setCode(code);
        Validation v = validationRepository.save(validation);
        notificationService.envoyerEmailVerificationUser(validation);
        return v;
    }

    @Override
    public Validation getValidationBuCode(String code) {
        return validationRepository.findValidationByCode(code);
    }
}
