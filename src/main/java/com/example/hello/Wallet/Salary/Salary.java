package com.example.hello.Wallet.Salary;

import com.example.hello.Org_Empl.Employee.Employee;
import com.example.hello.Wallet.Document.Document;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salary_id;
    private String type;
    @NotNull
    private Date billing_date;
    @NotNull
    private Float amount;
    private int periodicity;

    @ManyToOne
    @JoinColumn(name = "FK_employee_id", nullable = false, referencedColumnName = "employee_id")
    private Employee employee;


    public static class Builder {
        private int salary_id;
        private String type;
        private Date billing_date;
        private Float amount;
        private int periodicity;
        private Employee employee;

        public Builder setEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public Builder setSalary_id(int salary_id) {
            this.salary_id = salary_id;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setBilling_date(Date billing_date) {
            this.billing_date = billing_date;
            return this;
        }

        public Builder setAmount(Float amount) {
            this.amount = amount;
            return this;
        }

        public Builder setPeriodicity(int periodicity) {
            this.periodicity = periodicity;
            return this;
        }

        public Salary build()
        {
            return new Salary(salary_id, type, billing_date, amount, periodicity, employee);
        }

    }

}
