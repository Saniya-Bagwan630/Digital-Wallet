package com.saniya.LazyDemo;

import org.springframework.stereotype.Component;

@Component
public class Scholarship implements Student{
    public Scholarship(){
        System.out.println("Constructor: "+getClass().getSimpleName());
    }

    @Override
    public String type() {
        return "I am Smartttt..........!";
    }
}
