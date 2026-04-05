package com.pict.controller;
import com.pict.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class CalculatorController {
    @Autowired
    private List<CalculatorService> services;
    @Value("${calculator.n1}")
    private int n1;
    @Value("${calculator.n2}")
    private int n2;
    @Value("${calculator.operation}")
    private String operation;
    public void calculate(){
        for (CalculatorService service : services) {
            if(service.getOperationName().equalsIgnoreCase(operation)) {
                int result = service.calculate(n1, n2);
                System.out.println("\n\n Result of "+operation + " is "+result);
            }
        }
    }
}