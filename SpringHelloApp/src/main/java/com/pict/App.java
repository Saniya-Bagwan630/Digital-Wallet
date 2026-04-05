package com.pict;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        Hello hello = (Hello) context.getBean("helloBean");
        hello.Show();
        Student s = (Student) context.getBean("studentBean");
        System.out.println(s.display());
    }
}

