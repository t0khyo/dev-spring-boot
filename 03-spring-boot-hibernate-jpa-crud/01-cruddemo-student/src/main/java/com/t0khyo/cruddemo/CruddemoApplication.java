package com.t0khyo.cruddemo;

import com.t0khyo.cruddemo.dao.StudentDAO;
import com.t0khyo.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
		System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Abdelrahman", "Eltokhy", "abdelrahman.eltokhy@outlook.com");

        // save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

        // display id of the student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }

}
