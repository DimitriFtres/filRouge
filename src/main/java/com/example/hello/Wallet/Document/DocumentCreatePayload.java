package com.example.hello.Wallet.Document;

import com.example.hello.Org_Empl.Employee.Employee;
import com.example.hello.Org_Empl.Organization.Organization;
import com.example.hello.Wallet.Transaction.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentCreatePayload {
    private String name;
    private String description;
    private boolean free_access;
    private String path;
    private String type;
    private Employee employee;
    private Organization organization;
    private Transaction transaction;

}
