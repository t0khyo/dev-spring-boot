package com.t0khyo.springcoredemo.config;

import com.t0khyo.springcoredemo.common.Coach;
import com.t0khyo.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
