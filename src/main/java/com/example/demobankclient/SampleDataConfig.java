package com.example.demobankclient;


import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;

import java.util.Locale;

public class SampleDataConfig {
   @Bean
   Faker faker() {
        return new Faker(new Locale("en"));
    }
}
