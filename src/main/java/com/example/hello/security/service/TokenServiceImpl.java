package com.example.hello.security.service;

import com.example.hello.security.entity.response.TokenResponse;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class TokenServiceImpl implements TokenService{

    @Value("${server.tokenurl}")
    private String oauthTokenUrl;

    @Override
    public TokenResponse getRefreshToken(String refresh_token) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("refresh_token", refresh_token);
        map.add("grant_type", "refresh_token");
        return this.call(map);
    }

    @Override
    public TokenResponse getToken(String username, String password) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("username", username);
        map.add("password", password);
        map.add("grant_type", "password");
        return this.call(map);
    }

    private TokenResponse call(MultiValueMap<String, String> map){
        ResponseEntity<String> response = null;
        RestTemplate restTemplate = new RestTemplate();
        String credentials = "angular:angular-secret";
        String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Basic " + encodedCredentials);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        response = restTemplate.exchange(this.oauthTokenUrl, HttpMethod.POST, request, String.class);
        return new TokenResponse(Objects.requireNonNull(response.getBody()));
    }
}
