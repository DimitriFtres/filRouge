package com.example.hello.Org_Empl.Address;

import com.example.hello.Auth.Account.Account;
import com.example.hello.Contact.Contact.Contact;
import com.example.hello.Org_Empl.Employee.Employee;
import com.example.hello.Org_Empl.Organization.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressCreatePayload {
    private int address_id;
    private String type;
    private String road;
    private String number;
    private String box;
    private String cp;
    private String town;
    private String country;
}
