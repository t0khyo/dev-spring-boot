package com.t0khyo.demo.rest;

import com.t0khyo.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Mohamed", "Abdeljalil"));
        theStudents.add(new Student("Abdelrahman", "Eltokhy"));
        theStudents.add(new Student("Mazen", "Sedik"));

        return theStudents;
    }
}
