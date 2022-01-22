package com.example.hello.Wallet.Document;

import com.example.hello.Org_Empl.Organization.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
    Document findById(int id);

}
