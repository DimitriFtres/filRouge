package com.example.hello.Org_Empl.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
  Employee findById(int id);
}
