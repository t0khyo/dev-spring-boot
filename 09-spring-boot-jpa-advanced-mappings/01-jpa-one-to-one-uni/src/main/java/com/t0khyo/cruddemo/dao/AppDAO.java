package com.t0khyo.cruddemo.dao;

import com.t0khyo.cruddemo.entity.Instructor;
import org.springframework.stereotype.Repository;

@Repository
public interface AppDAO {
    void save(Instructor theInstructor);
}
