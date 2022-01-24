package com.example.hello.Org_Empl.Organization;

import com.example.hello.Org_Empl.Employee.EmployeeUpdatePayload;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int organization_id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    private boolean actif;

    public Organization(OrganizationUpdatePayload organization) {
        this.organization_id = organization.getOrganization_id();
        this.name = organization.getName();
        this.description = organization.getDescription();
    }

    public static class Builder
    {
        private int organization_id;
        private String name;
        private String description;
        private boolean actif;

        public Builder setOrganization_id(int organization_id) {
            this.organization_id = organization_id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setActif(boolean actif) {
            this.actif = actif;
            return this;
        }

        public Organization build()
        {
            return new Organization(organization_id, name, description, actif);
        }
    }
}
