package com.t0khyo.cruddemo;

import com.t0khyo.cruddemo.dao.StudentDAO;
import com.t0khyo.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);

            createMultipleStudents(studentDAO);

            // readStudent(studentDAO);

            // queryForStudents(studentDAO);

            // queryForStudentsByLastName(studentDAO);

            // updateStudent(studentDAO);

            // deleteStudent(studentDAO);

            // deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students ...");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 5;
        System.out.println("Deleting student with id:  " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrieve student based on the id: primary key
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student theStudent = studentDAO.findById(studentId);

        // change first name to "Johan"
        System.out.println("Updating student ...");
        theStudent.setFirstName("Johan");

        // update the student
        studentDAO.update(theStudent);

        // display the student
        System.out.println("Updated student: " + theStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findByLastName("Eltokhy");

        // display the list
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }

    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
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
