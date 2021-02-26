package com.example.demo.dao;

import com.example.demo.entities.Employee;
import com.example.demo.entities.EmployeeType;
import com.example.demo.events.SalaryChangeEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Component
public class EmployeeDaoImp extends JdbcDaoSupport implements EmployeeDao{
    private ApplicationEventPublisher eventPublisher;
    @PostConstruct
    private void initialize() throws SQLException {
        Connection dataSource = DriverManager.getConnection("jdbc:postgresql://localhost:5432/payroll", "postgres", "123");
    }

    @Override
    public void create(int id, String name, int salary, EmployeeType type) {
        String typeEmployee = type.toString();
        String sql = "INSERT INTO Employee values(?, ?, ?, ?)";
        getJdbcTemplate().update(sql, id, name, salary, typeEmployee);
        System.out.println("created!");
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, int salary) {
        this.eventPublisher.publishEvent(new SalaryChangeEvent());
    }

    @Override
    public List<Employee> getList() {
        return null;
    }
}
