package com.pict.service;

import org.springframework.stereotype.Service;

@Service
public class DivService implements CalculatorService{
    public String getOperationName(){
        return "div";
    }

    public int calculate(int a, int b){
        return a/b;
    }
}
