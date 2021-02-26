package com.example.demo;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.entities.EmployeeType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int choice = -1;
        while(choice!=0) {
            System.out.println("1. Salaried employees");
            System.out.println("2. Hourly employees");
            System.out.println("3. Commission employees");
            System.out.println("4. Salaried-commission employees");
            choice = in.nextInt();
            switch (choice){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
            }
        }

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
        employeeDao.create(1, "bob", 2000, EmployeeType.SALARIED);
        context.close();


    }
}

