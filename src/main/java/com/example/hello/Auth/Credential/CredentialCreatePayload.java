package com.example.hello.Auth.Credential;

import com.example.hello.Auth.Account.Account;
import com.example.hello.Org_Empl.Organization.Organization;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredentialCreatePayload {
    private String username;
    private String password;
    private String email;
    private boolean actif;
    private Account account;
}
