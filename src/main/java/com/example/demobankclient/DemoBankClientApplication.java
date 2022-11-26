package com.example.demobankclient;


import com.github.javafaker.Faker;
import model.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.PersonRepository;

import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;


@SpringBootApplication
@EnableJpaRepositories("repository")
@EntityScan("model")
@ComponentScan("com.example.*")
public class DemoBankClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoBankClientApplication.class, args);
    }
}
