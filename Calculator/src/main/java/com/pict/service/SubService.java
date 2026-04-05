package com.pict.service;

import org.springframework.stereotype.Service;

@Service
public class SubService implements CalculatorService{
    public String getOperationName(){
        return "sub";
    }

    public int calculate(int a, int b){
        return a-b;
    }
}
