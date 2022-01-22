package com.example.hello.Org_Empl.Organization;

import com.example.hello.Org_Empl.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    Organization findById(int id);

}
