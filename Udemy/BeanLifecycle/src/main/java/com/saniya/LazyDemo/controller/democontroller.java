package com.saniya.LazyDemo.controller;

import com.saniya.LazyDemo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class democontroller {
    private Student student;

    @Autowired
    public democontroller(@Qualifier("regular") Student s){
        student =s;
    }

    @GetMapping("/")
    String print(){
        return student.type();
    }
}
