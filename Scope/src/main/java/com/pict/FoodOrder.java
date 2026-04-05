package com.pict;

public class FoodOrder {
    String id;
    public FoodOrder(){
        id = "ID-" + System.nanoTime();
    }

    void Order(){
        System.out.println("Current FoodOrder: "+id);
    }

    String getId(){
        return id;
    }
}
