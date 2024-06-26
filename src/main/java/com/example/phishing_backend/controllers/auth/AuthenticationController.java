package com.example.phishing_backend.controllers.auth;

import com.example.phishing_backend.dto.AuthenticationDTO;
import com.example.phishing_backend.entities.User;
import com.example.phishing_backend.exceptions.ActivationException;
import com.example.phishing_backend.exceptions.RefreshTokenExpiredException;
import com.example.phishing_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/authentication")
@AllArgsConstructor
public class AuthenticationController {
    private final UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User userApp){
        return userService.registerUser(userApp);
    }

    @PostMapping("/activation")
    public ResponseEntity<String> activeAccount(@RequestBody Map<String , String> code){
        try{
            userService.activationAccount(code);
            return new ResponseEntity<String>("Activation a passed avec succes", HttpStatus.valueOf(200));
        }catch(ActivationException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(406));
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthenticationDTO authenticationInfo) throws RefreshTokenExpiredException {
        return userService.connexion(authenticationInfo);
    }

    @ExceptionHandler(RefreshTokenExpiredException.class)
    public ResponseEntity<Map<String, String>> handleRefreshTokenExpiredExcception (RefreshTokenExpiredException exception){
        return ResponseEntity.status(414).body(Map.of("error", exception.getMessage()));
    }
}