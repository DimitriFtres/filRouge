package com.example.hello.Wallet.Wallet;

import com.example.hello.Wallet.Document.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    Wallet findById(int id);

}
