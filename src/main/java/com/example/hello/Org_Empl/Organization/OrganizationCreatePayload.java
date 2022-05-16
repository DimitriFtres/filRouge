package com.example.hello.Org_Empl.Organization;

import com.example.hello.Org_Empl.Address.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationCreatePayload {
    private String name;
    private String description;
    private boolean actif;
    private List<Address> addresses;

}
