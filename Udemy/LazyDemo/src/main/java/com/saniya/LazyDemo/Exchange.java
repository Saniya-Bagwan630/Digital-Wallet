package com.saniya.LazyDemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Exchange implements Student{
    public Exchange(){
        System.out.println("Constructor: "+getClass().getSimpleName());
    }
    @Override
    public String type() {
        return "I am Fashionable!";
    }
}
