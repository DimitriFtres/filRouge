package com.example.hello.Org_Empl.Address;

import com.example.hello.Org_Empl.Employee.Employee;
import com.example.hello.Org_Empl.Organization.Organization;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int address_id;
    @NotNull
    private String type;
    @NotNull
    private String road;
    @NotNull
    private String number;
    @NotNull
    private String box;
    @NotNull
    private String cp;
    @NotNull
    private String town;
    @NotNull
    private String country;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = true, referencedColumnName = "organization_id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = true, referencedColumnName = "employee_id")
    private Employee employee;
}
