package com.example.hello.Org_Empl.Organization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationUpdatePayload {
    private int organization_id;
    private String name;
    private String description;
    private boolean actif;
}
