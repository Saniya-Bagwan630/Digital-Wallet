package com.pict;

import com.pict.controller.CalculatorController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class CalculatorApplication implements CommandLineRunner {

    @Autowired
    private CalculatorController calculatorController;

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }

    @Override
    public void run(String... args) {
        calculatorController.calculate();
    }
}