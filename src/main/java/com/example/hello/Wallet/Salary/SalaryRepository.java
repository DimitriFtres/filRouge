package com.example.hello.Wallet.Salary;

import com.example.hello.Wallet.Document.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {
    Salary findById(int id);

}
