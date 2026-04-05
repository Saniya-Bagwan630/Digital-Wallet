package com.pict;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        RestroMenu menu1 = (RestroMenu) context.getBean("menu");
        menu1.Menu();
        RestroMenu menu2 = (RestroMenu) context.getBean("menu");
        menu2.Menu();

        System.out.println("menu1 ID: "+menu1.getId());
        System.out.println("menu2 ID: "+menu2.getId());

        if(menu1==menu2){
            System.out.println("Singelton");
        }else{
            System.out.println("Prototype");
        }

        FoodOrder order1 = (FoodOrder) context.getBean("order");
        order1.Order();
        FoodOrder order2 = (FoodOrder) context.getBean("order");
        order2.Order();

        System.out.println("order1 ID: "+order1.getId());
        System.out.println("order2 ID: "+order2.getId());

        if(order1==order2){
            System.out.println("Singelton");
        }else{
            System.out.println("Prototype");
        }
    }
}
