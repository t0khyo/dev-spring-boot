package com.t0khyo.springboot.cruddemo.service;

import com.t0khyo.springboot.cruddemo.dao.EmployeeDAO;
import com.t0khyo.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
