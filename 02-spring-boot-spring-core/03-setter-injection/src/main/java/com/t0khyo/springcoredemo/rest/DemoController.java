package com.t0khyo.springcoredemo.rest;

import com.t0khyo.springcoredemo.common.Coach;
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
     *
     * Field Injection:
     *      - Not recommended by spring.io
     */

    // define a private field for the dependency
    private Coach myCoach;

    //setter injection
    @Autowired
    public void setMyCoach(Coach myCoach){
        this.myCoach = myCoach;
    }

    // define a constructor for dependency injection
//    @Autowired
//    public DemoController(Coach myCoach) {
//        this.myCoach = myCoach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
