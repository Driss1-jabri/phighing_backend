package com.example.phishing_backend;

import com.example.phishing_backend.SECURITY.RsaKeyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(RsaKeyConfig.class)
public class PhishingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhishingBackendApplication.class, args);
    }

}
