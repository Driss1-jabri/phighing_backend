package com.example.phishing_backend.mapping;

import com.example.phishing_backend.dto.EmailDto;
import com.example.phishing_backend.entities.Email;
import com.example.phishing_backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class Emailmapping {

    private final UserRepository userRepository;
    public Email fromDto(EmailDto emailDto)
    {
        return Email.builder()
                .id(emailDto.id())
                .body(emailDto.body())
                .isPhishing(emailDto.isPhishing())
                .sender(emailDto.sender())
                .subject(emailDto.subject())
                .user(userRepository.getReferenceById(emailDto.userID()))
                .build();
    }


    public EmailDto toDto(Email email)
    {
        return new EmailDto(email.getId(), email.getSubject(), email.getSender(), email.getSubject(), email.isPhishing(), email.getUser().getId());
    }
}
