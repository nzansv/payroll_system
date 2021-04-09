package com.example.demo.controller;

import com.example.demo.entities.Employee;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public Page<Employee> getAll() {
        return employeeService.getAll();
    }

    public List<Employee> getUserByName(String name) {
        return employeeService.getUsersByName(name);
    }
}
