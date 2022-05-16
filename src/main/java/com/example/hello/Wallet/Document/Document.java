package com.example.hello.Wallet.Document;

import com.example.hello.Org_Empl.Employee.Employee;
import com.example.hello.Org_Empl.Organization.Organization;
import com.example.hello.Wallet.Transaction.Transaction;
import com.example.hello.Wallet.Wallet.Wallet;
import com.example.hello.fileManager.entity.UploadFile;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int document_id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    private boolean free_access;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_file_id", referencedColumnName = "file_id")
    private UploadFile path;

    private String type;

    @ManyToOne
    @JoinColumn(name = "FK_employee_id", nullable = true, referencedColumnName = "employee_id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "FK_organization_id", nullable = true, referencedColumnName = "organization_id")
    private Organization organization;

    @OneToOne
    @JoinColumn(name = "FK_transaction_id", nullable = true, referencedColumnName = "transaction_id")
    private Transaction transaction;

    public static class Builder
    {
        private int document_id;
        private String name;
        private String description;
        private boolean free_access;
        private UploadFile path;
        private String type;
        private Employee employee;
        private Organization organization;
        private Transaction transaction;

        public Builder setTransaction(Transaction transaction) {
            this.transaction = transaction;
            return this;
        }

        public Builder setEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public Builder setOrganization(Organization organization) {
            this.organization = organization;
            return this;
        }

        public Builder setDocument_id(int document_id) {
            this.document_id = document_id;
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

        public Builder setFree_access(boolean free_access) {
            this.free_access = free_access;
            return this;
        }

        public Builder setPath(UploadFile path) {
            this.path = path;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Document build()
        {
            return new Document(document_id, name, description, free_access, path, type, employee, organization, transaction);
        }
    }




}
