package com.info.demo.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Employee number can not be blank.")
    @Column(name = "employee_number", nullable = false,unique = true, length = 4)
    private int employeeNumber;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    //Full Name Of Employee
    @Column(name = "full_name",  nullable = false)
    private String fullName;

    @Column(name = "type_of_items", nullable = false, length = 1)
    private int type;

    @Column(name = "way_to_use",  nullable = false, length = 20)
    private String wayOfUse;

    public Employee(int employeeNumber, String employeeName, String fullName, int type, String wayOfUse) {
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.fullName = fullName;
        this.type = type;
        this.wayOfUse = wayOfUse;
    }

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getWayOfUse() {
        return wayOfUse;
    }

    public void setWayOfUse(String wayOfUse) {
        this.wayOfUse = wayOfUse;
    }

    public String toString() {
        return id + " " + employeeName;
    }
}
