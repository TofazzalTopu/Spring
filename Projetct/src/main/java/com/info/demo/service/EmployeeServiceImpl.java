package com.info.demo.service;

import com.info.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    CrudRepository crudRepository;


    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        Iterable<Employee> employees = crudRepository.findAll();

        for (Employee employee : employees) {
            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    public Employee findEmployeeById(long id) {
        Iterable<Employee> employeeList = crudRepository.findAll();
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public Employee findEmployeeByEmployeeNumber(int employeeNumber) {
        Iterable<Employee> employeeList = crudRepository.findAll();
        for (Employee employee : employeeList) {
            if (employee.getEmployeeNumber() == employeeNumber) {
                return employee;
            }
        }
        return null;
    }
}
