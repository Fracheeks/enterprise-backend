package com.javatechie.keycloak.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Employee_user")
@NoArgsConstructor
@Data
public class Employee extends user {

    @Column(name = "salary")
    private double salary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "companyOwner_id")
    private companyOwner CompanyOwner=null;

    public Employee(String username, double salary) {
        super.username = username;
        this.salary = salary;
        super.roleName="employee";
    }

    public Employee(String username, double salary, companyOwner owner) {
        this.username = username;
        this.salary = salary;
        this.CompanyOwner=owner;
        super.roleName="employee";
    }

    public companyOwner getCompanyOwner() {
        return CompanyOwner;
    }
}
