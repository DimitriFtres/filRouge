package com.example.hello.Auth.Account;

import com.example.hello.Org_Empl.Organization.Organization;
import com.example.hello.security.entity.Credential;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreatePayload {
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    private Credential credential;

}
