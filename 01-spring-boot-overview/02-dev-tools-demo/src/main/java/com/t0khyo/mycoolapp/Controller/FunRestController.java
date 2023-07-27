package com.t0khyo.mycoolapp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" that return "Hello World!"
    @GetMapping("/")
    public String sayHello() {
        return "Hello world!";
    }

    // expose a new endpoint for workout
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 6k!";
    }

}
