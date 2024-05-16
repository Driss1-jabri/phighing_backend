package com.example.phishing_backend.service.serviceImpl;

import com.example.phishing_backend.entities.Url;
import com.example.phishing_backend.service.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UrlServiceImp  implements UrlService {


    @Override
    public Optional<Boolean> addUrl(Url url) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Url>> getUrl(String url) {
        return Optional.empty();
    }

    @Override
    public Optional<Url> getUrlById(Long id) {
        return Optional.empty();
    }


}
