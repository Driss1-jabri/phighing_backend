package com.example.phishing_backend.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "predictionClient", url = "http://127.0.0.1:5000")
public interface EmailPredectorController {
    @PostMapping("/predict")
    String predict(@RequestBody Map<String, String> map);
}
