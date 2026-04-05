package com.saniya.CInjection;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public void trains() {
        System.out.println("Trains Cricketers");
    }
}
