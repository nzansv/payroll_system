package com.example.demo.dao;

import com.example.demo.entities.Employee;
import com.example.demo.entities.EmployeeType;

import java.util.List;

public interface EmployeeDao {

    void create(int id, String name, int salary, EmployeeType type);

    void delete(int id);

    void update(int id, int updSalary);

    List<Employee> getList();

    Employee getEmployee(int id);
}
