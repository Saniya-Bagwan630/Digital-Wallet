package com.saniya.LazyDemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

//@Component is not used
//consider ir as 3rd party class
public class Regular implements Student{

    public Regular(){
        System.out.println("Constructor: "+getClass().getSimpleName());
    }

    @Override
    public String type() {
        return "I am Regular ha ha ha!";
    }
}
