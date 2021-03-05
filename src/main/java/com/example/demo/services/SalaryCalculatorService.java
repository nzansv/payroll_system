package com.example.demo.services;

import com.example.demo.entities.Employee;
import com.example.demo.entities.EmployeeType;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class SalaryCalculatorService {
    public Scanner in = new Scanner(System.in);
    public double percentage;
    public void calculateSalary(Employee employee){
        employee.toString();
        EmployeeType choice = employee.getEmplType();
        switch (choice){
            case SALARIED:
                System.out.println("Salary: " + employee.getFixedSalary() + " tg");
                break;
            case HOURLY:
                System.out.println("Salary: " + employee.getHourRate()*employee.getHoursWorked()+ " tg");
                break;
            case COMMISSION:
                System.out.println("Salary: " + employee.getGrossSales()*employee.getCommRate()/100+ " tg");
                break;
            case SALARIED_COMMISSION:
                System.out.println("Salary: " + employee.getGrossSales()*employee.getCommRate()/100+employee.getFixedSalary()+ " tg");
                break;
        }
    }
    public void increaseSalary(Employee employee){
        employee.toString();
        EmployeeType choice = employee.getEmplType();
        switch (choice){
            case SALARIED:
                System.out.println("Current Fixed Salary: " + employee.getFixedSalary() + " tg");
                System.out.println("Increase to(%): ");
                percentage = in.nextDouble();
                System.out.println("Increased Fixed Salary: " + employee.getFixedSalary()*percentage/100+employee.getFixedSalary() + " tg");
                break;
            case HOURLY:
                System.out.println("Only for employees with fixed salary!");
                break;
            case COMMISSION:
                System.out.println("Only for employees with fixed salary!");
                break;
            case SALARIED_COMMISSION:
                System.out.println("Current Fixed Salary: " + employee.getFixedSalary() + " tg");
                System.out.println("Increase based salary to(%): ");
                percentage = in.nextDouble();
                double newSalary = employee.getFixedSalary()*percentage/100+employee.getFixedSalary();
                System.out.println("Increased Fixed Salary: " + newSalary + " tg");
                break;
        }
    }

}
