package com.saniya.LazyDemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Regular implements Student{

    public Regular(){
        System.out.println("Constructor: "+getClass().getSimpleName());
    }

    @PostConstruct
    public void setup(){
        System.out.println("in setup of"+getClass().getSimpleName());
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("Inside cleanup of: "+getClass().getSimpleName());
    }
    @Override
    public String type() {
        return "I am Regular ha ha ha!";
    }
}
