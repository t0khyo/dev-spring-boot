package com.t0khyo.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.t0khyo.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it redundant... no need to write any code LOL!

    // add method to sort by last name
    public List<Employee> findAllByOrderByFirstNameAsc();
}
