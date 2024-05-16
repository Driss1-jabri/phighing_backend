package com.example.phishing_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PhishingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhishingBackendApplication.class, args);
    }

}
