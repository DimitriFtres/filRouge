package com.example.hello.Contact.Contact;

import com.example.hello.Auth.Account.Account;
import com.example.hello.Org_Empl.Address.Address;
import com.example.hello.Org_Empl.Organization.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactUpdatePayload {
    private int contact_id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private List<Address> addresses;
}
