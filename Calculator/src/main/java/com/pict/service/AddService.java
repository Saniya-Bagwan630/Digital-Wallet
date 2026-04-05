package com.pict.service;

import org.springframework.stereotype.Service;

@Service
public class AddService implements CalculatorService{
    public String getOperationName(){
        return "add";
    }

    public int calculate(int a, int b){
        return a+b;
    }
}
