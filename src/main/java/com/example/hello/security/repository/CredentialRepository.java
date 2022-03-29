package com.example.hello.security.repository;

import com.example.hello.security.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<Credential, Long> {
    Credential findByUsername(String username);

    boolean existsByUsername(String username);
}
