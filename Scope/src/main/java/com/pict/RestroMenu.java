package com.pict;

public class RestroMenu {
    String id;
    public RestroMenu(){
        id = "ID-" + System.nanoTime();
    }

    void Menu(){
        System.out.println("Current Menu: "+id);
    }

    String getId(){
        return id;
    }
}
