package com.example.demo;

import com.example.demo.config.SpringConfiguration;
import com.example.demo.controller.EmployeeController;
import com.example.demo.entities.Employee;
import com.example.demo.entities.EmployeeType;
import java.util.*;

import com.example.demo.services.SalaryCalculatorService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    public static EmployeeController employeeController = context.getBean("employeeController", EmployeeController.class);
    public static void main(String[] args) {

        SalaryCalculatorService service = context.getBean(SalaryCalculatorService.class);


        Employee e1 = context.getBean( Employee.class);
        e1.setEmployeeData(1L,"Bob",50000, 0, 0,0,0);
        e1.setEmplType(EmployeeType.SALARIED);
        employeeController.createEmployee(e1);

        Employee e2 = context.getBean(Employee.class);
        e2.setEmployeeData(2L,"John",0, 2000, 43,0,0);
        e2.setEmplType(EmployeeType.HOURLY);
        employeeController.createEmployee(e2);

        Employee e3 = context.getBean( Employee.class);
        e3.setEmployeeData(3L,"Alex",0, 0, 0,70,40000);
        e3.setEmplType(EmployeeType.COMMISSION);
        employeeController.createEmployee(e3);

        Employee e4 = context.getBean( Employee.class);
        e4.setEmployeeData(4L,"Billie",25000, 0, 0,50,35000);
        e4.setEmplType(EmployeeType.SALARIED_COMMISSION);
        employeeController.createEmployee(e4);



        int choice = -1;
        while (true) {

            System.out.println("1. List of Employees");
            System.out.println("2. Calculate Salary");
            System.out.println("3. Increase Salary");
            System.out.println("0. Exit");

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(employeeController.getAll().getContent());
                    break;
                case 2:
                    service.calculateSalary(getEmp());
                    break;
                case 3:
                    service.increaseSalary(getEmp());
                    break;
                case 0:
                    System.out.println("Exit");
                    return;
            }



        }
    }
    public static Employee getEmp(){
        System.out.println("Input ID: ");
        Long id = in.nextLong();
        Employee employee = employeeController.getEmployeeById(id);
        return employee;
    }
}
