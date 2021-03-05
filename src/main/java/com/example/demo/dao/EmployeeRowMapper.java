package com.example.demo.dao;
import com.example.demo.entities.Employee;
import com.example.demo.entities.EmployeeType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

        Employee employee = new Employee();

        employee.setId( resultSet.getLong("id"));
        employee.setName(resultSet.getString("name"));
        employee.setFixedSalary(resultSet.getInt("salary"));
        employee.setEmplType(EmployeeType.valueOf(resultSet.getString("type")));

        return employee;
    }
}
