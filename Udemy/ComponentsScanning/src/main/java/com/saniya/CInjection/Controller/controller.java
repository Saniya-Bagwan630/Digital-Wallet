package com.saniya.CInjection.Controller;

import com.utils.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    private Coach coach1;

    @Autowired
    controller(Coach c){
        coach1=c;
    }

    @GetMapping("/")
    String print(){
        System.out.println("Controller hit");
        coach1.trains();
        return "Check";
    }
}
