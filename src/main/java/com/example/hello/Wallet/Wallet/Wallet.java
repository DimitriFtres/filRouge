package com.example.hello.Wallet.Wallet;

import com.example.hello.Org_Empl.Employee.Employee;
import com.example.hello.Org_Empl.Organization.Organization;
import com.example.hello.Wallet.Transaction.Transaction;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int wallet_id;
    private String name;
    private String description;
    private boolean actif;
    private String type;

    @ManyToOne
    @JoinColumn(name = "FK_employee_id", nullable = false, referencedColumnName = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "FK_organization_id", nullable = false, referencedColumnName = "organization_id")
    private Organization organization;

    public static class Builder
    {
        private int wallet_id;
        private String name;
        private String description;
        private boolean actif;
        private String type;
        private Employee employee;

        public Builder setEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public Builder setOrganization(Organization organization) {
            this.organization = organization;
            return this;
        }

        private Organization organization;

        public Builder setWallet_id(int wallet_id) {
            this.wallet_id = wallet_id;
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

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Wallet build()
        {
            return new Wallet(wallet_id, name, description, actif, type, employee, organization);
        }

    }

}
