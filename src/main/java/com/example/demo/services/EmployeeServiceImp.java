package com.example.demo.services;


import com.example.demo.entities.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> getAll() {
        Pageable pageable = PageRequest.of(0, 6, Sort.by(Sort.Direction.DESC,"name"));
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElse(new Employee());
    }

    @Override
    public void update(Long id, Employee employee) {
        Optional<Employee> userOptional = employeeRepository.findById(id);

        if (userOptional.isPresent()) {
            Employee dbEmployee = userOptional.get();
            dbEmployee.setName(employee.getName());

            employeeRepository.save(dbEmployee);
        }
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
