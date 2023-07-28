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
            // createStudent(studentDAO);

            // createMultipleStudents(studentDAO);

            readStudent(studentDAO);
        };
    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Abdelrahman", "Eltokhy", "abdelrahman@t0khyo.com");

        // save the student
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        // retrieve student based on the id: primary key
        System.out.println("Retrieving the student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        // display student
        System.out.println("Found the student: " + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // create multiple student
        System.out.println("Creating 3 students objects ...");
        Student tempStudent1 = new Student("John", "Doe", "john@t0khyo.com");
        Student tempStudent2 = new Student("Max", "theo", "Max@t0khyo.com");
        Student tempStudent3 = new Student("Naser", "Ahmed", "Naser@t0khyo.com");

        // save the student objects
        System.out.println("saving the students ...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Abdelrahman", "Eltokhy", "abdelrahman@t0khyo.com");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of the student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }

}
