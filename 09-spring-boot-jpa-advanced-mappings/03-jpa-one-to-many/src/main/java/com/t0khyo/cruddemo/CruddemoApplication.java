package com.t0khyo.cruddemo;

import com.t0khyo.cruddemo.dao.AppDAO;
import com.t0khyo.cruddemo.entity.Course;
import com.t0khyo.cruddemo.entity.Instructor;
import com.t0khyo.cruddemo.entity.InstructorDetail;
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
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
             // createInstructor(appDAO);

            // findInstructor(appDAO);

            // deleteInstructor(appDAO);

            // findInstructorDetail(appDAO);

            // deleteInstructorDetail(appDAO);

            createInstructorWithCourses(appDAO);
        };
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

        int theId = 2;
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
                new Instructor("Abdelrahaman", "Eltokhy", "abdelrahman@t0khyo.com");

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
