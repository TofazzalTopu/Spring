package com.info.demo.service;

import com.info.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    public List<Employee> getAllEmployee();

    public Employee findEmployeeById(long id);

    public Employee findEmployeeByEmployeeNumber(int employeeNumber);
}
