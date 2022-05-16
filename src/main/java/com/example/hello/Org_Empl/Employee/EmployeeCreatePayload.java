package com.example.hello.Org_Empl.Employee;

import com.example.hello.Auth.Account.Account;
import com.example.hello.Org_Empl.Address.Address;
import com.example.hello.Org_Empl.Organization.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCreatePayload {
    private String role;
    private boolean actif;
    private Account account;
    private List<Address> addresses;
    private Organization organization;

}
