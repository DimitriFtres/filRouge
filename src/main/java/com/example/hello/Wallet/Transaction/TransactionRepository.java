package com.example.hello.Wallet.Transaction;

import com.example.hello.Wallet.Document.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findById(int id);

}
