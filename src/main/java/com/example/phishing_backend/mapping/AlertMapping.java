package com.example.phishing_backend.mapping;

import com.example.phishing_backend.dto.AlertDto;
import com.example.phishing_backend.entities.Alert;
import com.example.phishing_backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AlertMapping {
    private final UserRepository userRepository;

    public Alert fromDTO(AlertDto alertDto ){

        return Alert.builder()
                .id(alertDto.id())
                .isRead(alertDto.isRead())
                .message(alertDto.message())
                .timestamp(alertDto.timestamp())
                .user(userRepository.getReferenceById(alertDto.userId()))
                .build();

    }


    public AlertDto toDto(Alert alert)
    {
         return new AlertDto(alert.getId(), alert.getMessage(), alert.getTimestamp(), alert.isRead(),alert.getUser().getId());
    }


}

