package com.example.demo.services;

import com.example.demo.dao.*;
import com.example.demo.entities.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class SalaryCalculatorService {
    Scanner in = new Scanner(System.in);

    public void createEmployee(EmployeeDaoImp employeeDaoImp){
        System.out.println("ID: ");
        int id = in.nextInt();
        System.out.println("Name: ");
        String name = in.next();
        System.out.println("Salary: ");
        int salary = in.nextInt();
        EmployeeType employeeType;

        System.out.println("Employee's type: ");
        System.out.println("1." + EmployeeType.SALARIED);
        System.out.println("2." + EmployeeType.HOURLY);
        System.out.println("3." + EmployeeType.COMMISSION);
        System.out.println("4." + EmployeeType.SALARIED_COMMISSION);

        int choice = in.nextInt();

        switch(choice){
            case 1:
                employeeType = EmployeeType.SALARIED;
                break;
            case 2:
                employeeType = EmployeeType.HOURLY;
                break;
            case 3:
                employeeType = EmployeeType.COMMISSION;
                break;
            case 4:
                employeeType = EmployeeType.SALARIED_COMMISSION;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }

        employeeDaoImp.create(id, name, salary, employeeType);
    }

    public void deleteEmployee(EmployeeDaoImp employeeDaoImp){
        System.out.println("ID : ");
        int id = in.nextInt();
        employeeDaoImp.delete(id);
    }

    public void changeSalary(EmployeeDaoImp employeeDaoImp){

        System.out.println("ID:");
        int id = in.nextInt();
        Employee employee = employeeDaoImp.getEmployee(id);
        double currentSalary = employee.getFixedSalary();

        System.out.println("****************");
        System.out.println(employee.getId());
        System.out.println(employee.getName());
        System.out.println(employee.getFixedSalary());
        System.out.println("**************** ");
        System.out.println("1. Increase");
        System.out.println("2. Decrease");
        int choice = in.nextInt();
        switch (choice){
            case 1:
                System.out.print("Percentage: ");
                int percentage = in.nextInt();
                employeeDaoImp.update(id, (int) (currentSalary + currentSalary * percentage / 100));
                break;
            case 2:
                System.out.print("Percentage: ");
                int per = in.nextInt();
                employeeDaoImp.update(id, (int) (currentSalary - currentSalary * per / 100));
                break;
        }
    }

    public void getList(EmployeeDaoImp employeeDaoImp){
        List<Employee> employees = employeeDaoImp.getList();
        for(Employee employee : employees){
            System.out.println(employee.toString());
        }
    }

}
