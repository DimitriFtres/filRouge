package com.example.hello.Wallet.Wallet;

import com.example.hello.Org_Empl.Employee.Employee;
import com.example.hello.Org_Empl.Organization.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletCreatePayload {
    private String name;
    private String description;
    private boolean actif;
    private String type;
    private Employee employee;

}
