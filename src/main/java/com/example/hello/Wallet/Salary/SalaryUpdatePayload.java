package com.example.hello.Wallet.Salary;

import com.example.hello.Org_Empl.Employee.Employee;
import com.example.hello.Org_Empl.Organization.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryUpdatePayload {
    private int salary_id;
    private String type;
    private Date billing_date;
    private Float amount;
    private int periodicity;
    private Employee employee;
}
