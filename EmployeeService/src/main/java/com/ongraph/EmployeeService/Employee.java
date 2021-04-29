package com.ongraph.EmployeeService;

import lombok.Data;

@Data
public class Employee {

    private String name;
    private int id;

    Employee(){}

    Employee(int id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + "]";
    }
}
