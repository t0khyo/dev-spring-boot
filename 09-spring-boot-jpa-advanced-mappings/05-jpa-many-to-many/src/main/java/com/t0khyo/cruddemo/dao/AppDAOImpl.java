package com.t0khyo.cruddemo.dao;

import com.t0khyo.cruddemo.entity.Course;
import com.t0khyo.cruddemo.entity.Instructor;
import com.t0khyo.cruddemo.entity.InstructorDetail;
import com.t0khyo.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
    ToDo:
        * define field for entity manager
        * inject entity manger using constructor injection
 */

@Repository
public class AppDAOImpl implements AppDAO {

    private final EntityManager entityManager;

    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        // gonna retrieve the instructor detail object
        // because of default behavior of @OneToOne fetch type is eager ...
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        // retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        // get the courses
        List<Course> courses = tempInstructor.getCourses();

        // break association of all courses for the instructor
        for (Course tempCourse : courses) {
            tempCourse.setInstructor(null);
        }

        // delete the instructor - will also delete instructor details
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteConstructorDetailById(int theId) {
        // retrieve the constructor detail
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        // remove teh associated object reference
        // break bi-directional link
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        // delete the instructor detail
        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        // create the query
        TypedQuery<Course> query = entityManager.createQuery(
                "FROM Course WHERE instructor.id = :data", Course.class);
        query.setParameter("data", theId);

        // execute the query
        List<Course> theCourses = query.getResultList();
        return theCourses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        // create query
        TypedQuery<Instructor> query = entityManager.createQuery(
                "SELECT i FROM Instructor i " +
                        "JOIN FETCH i.courses " +
                        "WHERE i.id = :data", Instructor.class);
        query.setParameter("data", theId);

        // execute query
        Instructor theInstructor = query.getSingleResult();
        return theInstructor;
    }

    @Override
    @Transactional // used when we're modifying the database
    public void update(Instructor theInstructor) {
        entityManager.merge(theInstructor);
    }

    @Override
    @Transactional
    public void update(Course theCourse) {
        entityManager.merge(theCourse);
    }

    @Override
    public Course findCourseById(int theId) {
        Course theCourse = entityManager.find(Course.class, theId);
        return theCourse;
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        // retrieve the course
        Course tempCourse = entityManager.find(Course.class, theId);

        // delete the course
        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        // create query
        TypedQuery<Course> query = entityManager.createQuery(
                "SELECT c from Course c "
                        + "JOIN FETCH c.reviews "
                        + "WHERE c.id = :data", Course.class);
        query.setParameter("data", theId);

        // execute the query
        Course theCourse = query.getSingleResult();

        return theCourse;
    }

    @Override
    public Course findCourseAndStudentByCourseId(int theId) {
        // create query
        TypedQuery<Course> query = entityManager.createQuery(
                "SELECT c from Course c "
                        + "JOIN FETCH c.students "
                        + "WHERE c.id = :data", Course.class);
        query.setParameter("data", theId);

        // execute query
        Course course = query.getSingleResult();

        return course;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {
        // create query
        TypedQuery<Student> query = entityManager.createQuery(
                "SELECT s from Student s "
                        + "JOIN FETCH s.courses "
                        + "WHERE s.id = :data", Student.class);
        query.setParameter("data", theId);

        // execute query
        Student student = query.getSingleResult();

        return student;
    }
}
