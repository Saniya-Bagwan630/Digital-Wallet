package com.saniya.LazyDemo;

import org.springframework.stereotype.Component;

@Component
public class Regular implements Student{

    public Regular(){
        System.out.println("Constructor: "+getClass().getSimpleName());
    }
    @Override
    public String type() {
        return "I am Regular ha ha ha!";
    }
}
