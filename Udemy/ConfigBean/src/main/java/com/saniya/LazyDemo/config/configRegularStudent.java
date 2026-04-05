package com.saniya.LazyDemo.config;

import com.saniya.LazyDemo.Regular;
import com.saniya.LazyDemo.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configRegularStudent {

    @Bean
    Student regularStudent(){
        return new Regular();
    }
}
