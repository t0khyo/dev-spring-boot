package com.t0khyo.util;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout(){
        return "Practice fast bowling for 15 minutes";
    }
}