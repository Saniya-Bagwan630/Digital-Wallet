package com.saniya.SInjection;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{
    @Override
    public void trains() {
        System.out.println("Trains Football Players");
    }
}
