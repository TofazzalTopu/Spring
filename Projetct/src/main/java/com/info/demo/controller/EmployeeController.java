package com.info.demo.controller;


import com.info.demo.model.Employee;
import com.info.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    CrudRepository crudRepository;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexForm() {
        return "index";
    }

    //This method is to show employee registration form
    @RequestMapping(value = "/registrationForm", method = RequestMethod.GET)
    public String registrationForm() {
        return "employeeForm";
    }

    //This method is to create employee from user input
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute("employee") @Validated Employee employee,
                         BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        crudRepository.save(employee);
        model.addAttribute("success", "Employee created successfully.");
        return "employeeForm";
    }

    //This method is to view employee list
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String employeeList(Model model) {
        List<Employee> employeeList = employeeService.getAllEmployee();
        model.addAttribute("employees", employeeList);
        return "employeeList";
    }

    //This method is to find a specific employee by id
    @RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable(value = "id") String id, Model model) {
        Long idd = Long.parseLong(id);
        Employee employee = employeeService.findEmployeeById(idd);
        model.addAttribute("employees", employee);
        return "employeeDetails";

    }

    //This method is to load search employee form
    @RequestMapping(value = "/searchEmployeeForm", method = RequestMethod.GET)
    public String searchEmployeeForm() {
        return "searchEmployee";
    }

    //This method is to find a specific employee by employee number
    @RequestMapping(value = "/getEmployeeByEmployeeNumber/{employeeNumber}", method = RequestMethod.GET)
    public String getEmployeeById(@RequestParam(value = "employeeNumber") int employeeNumber, Model model) {
        Employee employee = employeeService.findEmployeeByEmployeeNumber(employeeNumber);
        model.addAttribute("employees", employee);
        return "searchEmployee";
    }

    //This method is to find a specific employee by employee number from browser
    //Url Like 'http://localhost:8080/employee/getByEmployeeNumber/1234'
    @RequestMapping(value = "/getByEmployeeNumber/{employeeNumber}", method = RequestMethod.GET)
    public String getByEmployeeNumber(@PathVariable(value = "employeeNumber") int employeeNumber, Model model) {
        Employee employee = employeeService.findEmployeeByEmployeeNumber(employeeNumber);
        model.addAttribute("employees", employee);
        return "searchEmployee";
    }
}
