package com.example.phishing_backend.exceptions;

public class RefreshTokenExpiredException extends Exception{
    public RefreshTokenExpiredException(String message){
        super(message);
    }
}
