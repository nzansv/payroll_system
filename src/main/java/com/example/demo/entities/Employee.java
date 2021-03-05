package com.example.demo.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table
@Component
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private double fixedSalary;
    @Column
    private double hourRate;
    @Column
    private int hoursWorked;
    @Column
    private float commRate;
    @Column
    private double grossSales;

    @Column
    private EmployeeType emplType;

    @Override
    public String toString() {
        return "\n---------------" +
                "\nid=" + id +
                "\nname: " + name + '\'' +
                "\nfixedSalary: " + fixedSalary +
                "\nhourRate: " + hourRate +
                "\nhoursWorked: " + hoursWorked +
                "\ncommRate: " + commRate +
                "\ngrossSales: " + grossSales +
                "\nemplType: " + emplType;
    }

    public void setEmployeeData(Long id, String name, double fixedSalary, double hourRate, int hoursWorked, float commRate, double grossSales) {

        this.id = id;
        this.name = name;
        this.fixedSalary = fixedSalary;
        this.hourRate = hourRate;
        this.hoursWorked = hoursWorked;
        this.commRate = commRate;
        this.grossSales = grossSales;
    }
}
