package com.pict.service;

import org.springframework.stereotype.Service;

@Service
public class MulService implements CalculatorService{
    public String getOperationName(){
        return "mul";
    }

    public int calculate(int a, int b){
        return a*b;
    }
}
