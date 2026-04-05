package com.saniya.SInjection.Controller;

import com.saniya.SInjection.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    private Coach mycoach;

    @Autowired
    void setMycoach(Coach c){
        mycoach=c;
    }

    @GetMapping("/")
    void print(){
        mycoach.trains();
    }

}
