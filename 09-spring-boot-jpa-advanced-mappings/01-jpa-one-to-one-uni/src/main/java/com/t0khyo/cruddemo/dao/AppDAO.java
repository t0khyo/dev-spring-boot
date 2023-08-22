package com.t0khyo.cruddemo.dao;

import com.t0khyo.cruddemo.entity.Instructor;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Repository;

@Repository
public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}
