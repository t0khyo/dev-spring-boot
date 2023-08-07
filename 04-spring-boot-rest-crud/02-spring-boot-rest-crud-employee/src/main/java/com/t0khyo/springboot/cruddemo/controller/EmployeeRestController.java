package com.t0khyo.springboot.cruddemo.controller;

import com.t0khyo.springboot.cruddemo.dao.EmployeeDAO;
import com.t0khyo.springboot.cruddemo.entity.Employee;
import com.t0khyo.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    EmployeeService employeeService;

    // quick and dirty: inject the employee DAO directly
    @Autowired
    public EmployeeRestController(EmployeeService employeeServices) {
        this.employeeService = employeeServices;
    }

    // expose "/employees" and return list of employees
    @GetMapping("employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
