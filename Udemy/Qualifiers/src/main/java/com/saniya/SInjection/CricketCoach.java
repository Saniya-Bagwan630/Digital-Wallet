package com.saniya.SInjection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements Coach{
    @Override
    public void trains() {
        System.out.println("Trains Cricketers!!");
    }
}
