package com.example.hello.security.config;

import com.example.hello.security.entity.Credential;
import com.example.hello.security.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    CredentialService credentialService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Credential credential = credentialService.findCredentialByUsername(username);
        if (credential == null)
            throw new UsernameNotFoundException("api.auth.user-not-found");

        List<GrantedAuthority> auths = new ArrayList<>();

        return new org.springframework.security.core.
                userdetails.User(credential.getUsername(), credential.getPassword(), auths);

    }
}
