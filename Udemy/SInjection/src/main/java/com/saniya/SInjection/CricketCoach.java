package com.saniya.SInjection;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public void trains() {
        System.out.println("Trains Cricketers!!");
    }
}
