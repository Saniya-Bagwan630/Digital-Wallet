package com.pict;

public class Laptop {
    private Processor processor;

    public Laptop(Processor processor){
        this.processor = processor;
    }
    public void run(){
        processor.process();
        System.out.println("Laptop is running");
    }
}
