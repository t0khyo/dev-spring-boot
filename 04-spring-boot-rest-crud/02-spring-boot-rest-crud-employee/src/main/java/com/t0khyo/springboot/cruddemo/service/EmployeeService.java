package com.t0khyo.springboot.cruddemo.service;

import com.t0khyo.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
