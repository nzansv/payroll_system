package com.example.demo;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.entities.EmployeeType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
        employeeDao.create(1, "bob", 2000, EmployeeType.SALARIED);
        context.close();

    }
}

