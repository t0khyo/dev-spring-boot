package com.t0khyo.springboot.cruddemo.dao;

import com.t0khyo.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
