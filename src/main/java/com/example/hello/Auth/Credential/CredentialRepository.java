package com.example.hello.Auth.Credential;

import com.example.hello.Org_Empl.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<Credential,Integer> {
  Credential findById(int id);
}
