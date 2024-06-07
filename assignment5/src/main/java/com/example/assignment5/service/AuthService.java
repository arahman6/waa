package com.example.assignment5.service;

import com.example.assignment5.entity.dto.request.LoginRequest;
import com.example.assignment5.entity.dto.request.RefreshTokenRequest;
import com.example.assignment5.entity.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
