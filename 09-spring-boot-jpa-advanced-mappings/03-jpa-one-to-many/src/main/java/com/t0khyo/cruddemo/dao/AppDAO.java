package com.t0khyo.cruddemo.dao;

import com.t0khyo.cruddemo.entity.Course;
import com.t0khyo.cruddemo.entity.Instructor;
import com.t0khyo.cruddemo.entity.InstructorDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteConstructorDetailById(int theId);

    public List<Course> findCoursesByInstructorId(int theId);
}
