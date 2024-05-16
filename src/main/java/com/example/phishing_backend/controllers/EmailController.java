package com.example.phishing_backend.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/email")
@RestController
@AllArgsConstructor
public class EmailController {
    private final EmailPredectorController predictionClient;

    @PostMapping("/makePrediction")
    public String makePrediction(@RequestBody String text) {
        return predictionClient.predict(Map.of("text", text));
    }
}
