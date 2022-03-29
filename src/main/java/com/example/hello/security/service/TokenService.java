package com.example.hello.security.service;

import com.example.hello.security.entity.response.TokenResponse;

public interface TokenService {
    TokenResponse getRefreshToken(String refresh_token);
    TokenResponse getToken(String username, String password);
}
