package com.javatechie.keycloak.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
@NoArgsConstructor
@Data
public class Employee extends user {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "companyOwner_id")
    @JsonIgnore
    private companyOwner CompanyOwner=null;

    public Employee(String username, double salary) {
        super.username = username;
        super.salary = salary;
        super.roleName="employee";
    }

    public Employee(String username, double salary, companyOwner owner) {
        this.username = username;
        this.salary = salary;
        this.CompanyOwner=owner;
        super.roleName="employee";
    }

    public Employee (String username, String userIdByToken){
        super.username=username;
        this.userIdByToken=userIdByToken;
        super.roleName="employee";
    }
}
