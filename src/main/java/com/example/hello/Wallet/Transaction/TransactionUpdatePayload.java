package com.example.hello.Wallet.Transaction;

import com.example.hello.Org_Empl.Employee.Employee;
import com.example.hello.Org_Empl.Organization.Organization;
import com.example.hello.Wallet.Document.Document;
import com.example.hello.Wallet.Wallet.Wallet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionUpdatePayload {
    private int transaction_id;
    private String type;
    private Float amount;
    private Wallet wallet;
    private Document document;
}
