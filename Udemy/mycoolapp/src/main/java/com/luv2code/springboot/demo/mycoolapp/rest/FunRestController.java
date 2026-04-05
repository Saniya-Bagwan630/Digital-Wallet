package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello(){
        System.out.println("Hello World");
        return "Hello World";
    }

    @GetMapping("/saniya")
    public String Saniya(){
        return"Saniya";
    }

    @GetMapping("/today")
    public String today(){
        return "Today is a Great Day!";
    }

    @Value("${cartoon.name}")
    private String name;

    @GetMapping("/cartoon")
    public String cartoon(){
        return name;
    }
}
