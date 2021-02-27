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

    String create_employee = "INSERT INTO Employee values(?, ?, ?, ?)";
    String update_employee = "UPDATE Employee SET salary=? WHERE id=?";
    String delete_employee = "DELETE FROM Employee WHERE id=?";
    String list_employee = "SELECT * FROM Employee";
    String get_employee = "SELECT * FROM Employee WHERE id=?";

    @PostConstruct
    private void initialize() throws SQLException {
        DriverManagerDataSource dataSource = (DriverManagerDataSource) DriverManager.getConnection("jdbc:postgresql://localhost:5432/payroll", "postgres", "123");
        setDataSource(dataSource);
    }

    public EmployeeDaoImp(ApplicationEventPublisher eventPublisher) {

        this.eventPublisher = eventPublisher;
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    @Override
    public void create(int id, String name, int salary, EmployeeType type) {
        String typeEmployee = type.toString();
        getJdbcTemplate().update(create_employee, id, name, salary, typeEmployee);
        System.out.println("created!");
    }

    @Override
    public void delete(int id) {
        getJdbcTemplate().update(delete_employee, id);
    }

    @Override
    public void update(int id, int updSalary) {
        getJdbcTemplate().update(update_employee, updSalary, id);
        this.eventPublisher.publishEvent(new SalaryChangeEvent(this, getEmployee(id)));
    }

    public Employee getEmployee(int id) {
        Employee employee = getJdbcTemplate().queryForObject(get_employee, new Object[]{id}, new EmployeeRowMapper());
        return employee;
    }

    @Override
    public List<Employee> getList() {
        List<Employee> employees = getJdbcTemplate().query(list_employee, new EmployeeRowMapper());
        return employees;
    }

}
