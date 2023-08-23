package com.t0khyo.cruddemo;

import com.t0khyo.cruddemo.dao.AppDAO;
import com.t0khyo.cruddemo.entity.*;
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
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            // createCourseAndStudents(appDAO);

            // findCourseAndStudents(appDAO);

            // findStudentAndCourses(appDAO);

            addMoreCoursesForStudent(appDAO);
        };
    }

    private void addMoreCoursesForStudent(AppDAO appDAO) {
        int theId = 2;
        Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

        // create more courses
        Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
        Course tempCourse2 = new Course("Atari 2600 - Game Development");

        // add courses to student
        tempStudent.addCourse(tempCourse1);
        tempStudent.addCourse(tempCourse2);

        System.out.println("Saving student: " + tempStudent);
        System.out.println("associated courses: " + tempStudent.getCourses());

        appDAO.update(tempStudent);

        System.out.println("Done!");
    }

    private void findStudentAndCourses(AppDAO appDAO) {
        int theId = 2;
        Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

        System.out.println("Loaded student: " + tempStudent);
        System.out.println("Courses: " + tempStudent.getCourses());

        System.out.println("Done!");
    }

    private void findCourseAndStudents(AppDAO appDAO) {
        int theId = 10;
        Course tempCourse = appDAO.findCourseAndStudentByCourseId(theId);

        System.out.println("Loaded course: " + tempCourse);
        System.out.println("Student: " + tempCourse.getStudents());

        System.out.println("Done!");
    }

    private void createCourseAndStudents(AppDAO appDAO) {
        // create course and students
        Course tempCourse = new Course("Pacman - How to Score One Million points");

        // create the students
        Student tempStudent1 = new Student("Ahmed", "Rashed", "Ahmed@t0khyo.dev");
        Student tempStudent2 = new Student("Mohamed", "Alaam", "Alaam@t0khyo.ops");
        Student tempStudent3 = new Student("Ziad", "Amer", "Ziad@t0khyo.dev");

        // add student to the course
        tempCourse.addStudent(tempStudent1);
        tempCourse.addStudent(tempStudent2);
        tempCourse.addStudent(tempStudent3);

        // save the course and associated students
        System.out.println("Saving course: " + tempCourse);
        System.out.println("associated student: " + tempCourse.getStudents());

        appDAO.save(tempCourse);

        System.out.println("Done!");
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        int theId = 10;
        System.out.println("Deleting course id: " + theId);
        appDAO.deleteCourseById(theId);
        System.out.println("Done!");
    }


    private void retrieveCourseAndReviews(AppDAO appDAO) {
        // get the course and reviews
        int theId = 10;
        Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

        // print the course
        System.out.println(tempCourse);

        // print the reviews
        System.out.println(tempCourse.getReviews());

        System.out.println("Done!");
    }

    private void createCourseAndReviews(AppDAO appDAO) {
        // create course
        Course tempCourse = new Course("Pacman - How to score one million points");

        // add some reviews
        tempCourse.addReview(new Review("Great course ... Loved it!"));
        tempCourse.addReview(new Review("Cool course ... job well done.!"));
        tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

        // save the course ... and leverage the cascade all
        System.out.println("Saving the course");
        System.out.println(tempCourse);
        System.out.println(tempCourse.getReviews());

        appDAO.save(tempCourse);

        System.out.println("Done!");
    }

    private void deleteCourse(AppDAO appDAO) {
        int theId = 10;

        System.out.println("Deleting course id: " + theId);
        appDAO.deleteCourseById(theId);

        System.out.println("Done!");
    }

    private void updateCourse(AppDAO appDAO) {
        int theId = 10;

        // find the course
        System.out.println("Finding course id: " + theId);
        Course tempCourse = appDAO.findCourseById(theId);

        // update the course
        System.out.println("Updating course id: " + theId);
        tempCourse.setTitle("DS 101 - The Ultimate Guid");

        appDAO.update(tempCourse);

        System.out.println("Done!");
    }

    private void updateInstructor(AppDAO appDAO) {
        int theId = 1;

        // find the instructor
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        // update the instructor
        System.out.println("Updating the instructor id: " + theId);
        tempInstructor.setLastName("TESTER");

        appDAO.update(tempInstructor);

        System.out.println("Done!");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int theId = 1;

        // find the instructor
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);

        // find courses for instructor
        System.out.println("Finding courses for instructor id: " + theId);
        List<Course> courses = appDAO.findCoursesByInstructorId(theId);

        // associate the objects
        tempInstructor.setCourses(courses);

        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("the Instructor: " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        // create the instructor
        Instructor tempInstructor =
                new Instructor("Abdelrahman", "Eltokhy", "abdelrahman@t0khyo.com");

        // create the instructor detail
        InstructorDetail instructorDetail = new InstructorDetail("http://www.t0khyo.com/youtube",
                "love 2 code!!!");

        // associate the objects
        tempInstructor.setInstructorDetail(instructorDetail);

        // create some courses
        Course tempCourse1 = new Course("DS 101 - The Ultimate Guid");
        Course tempCourse2 = new Course("DB design - The Master Class");

        // add courses to instructor
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        // save the instructor
        //
        // Note: this will ALSO save the courses
        // because of CascadeType.PERSIST
        //
        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("The courses: " + tempInstructor.getCourses());
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId = 4;
        System.out.println("Deleting instructor id: " + theId);

        appDAO.deleteConstructorDetailById(theId);

        System.out.println("Done!");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        /*  ToDo:
         * get the instructor detail object
         * print the constructor detail
         * print the associated instructor
         */
        int theId = 1;
        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

        System.out.println("tempInstructorDetail: " + tempInstructorDetail);

        System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

        System.out.println("Done!");
    }

    private void deleteInstructor(AppDAO appDAO) {

        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        appDAO.deleteInstructorById(theId);

        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("the Instructor: " + tempInstructor);
        System.out.println("the associated instructor detail only: " + tempInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
        /* ToDo:
         * create instructor
         * create instructor detail
         * associate the objects
         * save the instructor
         */

        // Instructor tempInstructor =
        // 		new Instructor("Chad", "Darby", "darby@luv2code.com");
        //
        // InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
        // 		"Luv 2 code!!");

        Instructor tempInstructor =
                new Instructor("Abdelrahman", "Eltokhy", "abdelrahman@t0khyo.com");

        InstructorDetail instructorDetail = new InstructorDetail("http://www.t0khyo.com/youtube",
                "love 2 code!!!");

        tempInstructor.setInstructorDetail(instructorDetail);

        // NOTE: this will ALSO save details object
        // because of CascadeType.ALL
        System.out.println("Saving instructor" + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }
}
