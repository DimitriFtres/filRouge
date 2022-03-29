package com.example.hello.security.service;

import com.example.hello.Common.ApiResponse;
import com.example.hello.security.entity.Credential;
import com.example.hello.security.entity.payload.SignupRequest;

public interface CredentialService {

    Credential saveCredential(Credential credential);

    Credential findCredentialByUsername(String username);

    ApiResponse signup(SignupRequest request);

}