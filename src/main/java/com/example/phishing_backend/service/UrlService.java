package com.example.phishing_backend.service;

import com.example.phishing_backend.entities.Url;

import java.util.List;
import java.util.Optional;

public interface UrlService {
    Optional<Boolean> addUrl(Url url);
    Optional<List<Url>> getUrl(String url);
    Optional<Url> getUrlById(Long id);
}
