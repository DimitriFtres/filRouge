package com.example.hello.Auth.Account;

import com.example.hello.Org_Empl.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
  Account findById(int id);
}
