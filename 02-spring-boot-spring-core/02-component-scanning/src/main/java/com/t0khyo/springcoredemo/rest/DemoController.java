package com.t0khyo.springcoredemo.rest;

import com.t0khyo.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    /*
     * Constructor injection:
     *      - for required dependencies
     *      - recommended by spring.io
     *
     * Setter injection:
     *      - for optional dependencies,
     *      - if dependency is not provided
     */

    // define a private field for the dependency
    private Coach myCoach;

    // define a constructor for dependency injection
    @Autowired
    public DemoController(Coach myCoach) {
        this.myCoach = myCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
