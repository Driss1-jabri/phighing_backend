package com.example.phishing_backend.mapping;

import com.example.phishing_backend.dto.UserDto;
import com.example.phishing_backend.entities.Alert;
import com.example.phishing_backend.entities.Email;
import com.example.phishing_backend.entities.User;
import com.example.phishing_backend.repositories.AlertRepository;
import com.example.phishing_backend.repositories.EmailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class UserMApping {

    private final EmailRepository emailRepository;
    private final AlertRepository alertRepository;


    public User fromDto(UserDto userDto){
        List<Email> emails = new ArrayList<>();
        List<Alert> alerts = new ArrayList<>();

        userDto.emailIds().forEach((id) ->{
            emails.add(emailRepository.getReferenceById(id));
        });


        userDto.alertIds().forEach((id) ->{
            alerts.add(alertRepository.getReferenceById(id));
        });
        return User.builder()
                .id(userDto.id())
                .email(userDto.email())
                .username(userDto.username())
                .emails(emails)
                .alerts(alerts)
                .build();
    }


    public UserDto toDto(User user)
    {
        List<Long> emailIds = new ArrayList<>();
        List<Long> alertIds = new ArrayList<>();

        user.getAlerts().forEach((alert) ->{
            alertIds.add(alert.getId());
        });

        user.getEmails().forEach((email) ->{
            emailIds.add(email.getId());
        });

       return new UserDto(user.getId(), user.getUsername(), user.getEmail(),emailIds,alertIds );
    }
}
