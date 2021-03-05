package com.example.demo;
import com.example.demo.controller.EmployeeController;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.dao.EmployeeDaoImp;
import com.example.demo.entities.EmployeeType;
import com.example.demo.services.SalaryCalculatorService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

         EmployeeController employeeController = context.getBean("employeeController", EmployeeController.class);

        System.out.println(employeeController.getAll().getContent());

//        Scanner in = new Scanner(System.in);
//
//        EmployeeDaoImp employeeDaoImp = context.getBean(EmployeeDaoImp.class);
//        SalaryCalculatorService service = context.getBean(SalaryCalculatorService.class);
//
//        int choice = -1;
//        while(true){
//
//            System.out.println("1. Create Employee");
//            System.out.println("2. Delete Employee");
//            System.out.println("3. Change Salaries");
//            System.out.println("4. List of Employees");
//            System.out.println("0. Exit");
//
//            System.out.println("Choice -> ");
//            choice = in.nextInt();
//
//            switch (choice){
//                case 1:
//                    service.createEmployee(employeeDaoImp);
//                    break;
//                case 2:
//                    service.deleteEmployee(employeeDaoImp);
//                    break;
//                case 3:
//                    service.changeSalary(employeeDaoImp);
//                    break;
//                case 4:
//                    service.getList(employeeDaoImp);
//                    break;
//                case 0:
//                    System.out.println("Exit");
//                    return;
//            }
//        }


    }

}
