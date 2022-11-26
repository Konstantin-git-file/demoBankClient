package com.example.demobankclient;

import com.github.javafaker.Faker;
import model.Address;
import model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@EnableAutoConfiguration
public class PersonDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(PersonDataLoader.class);


    private final PersonRepository personRepository;
    private final Faker faker;

    public PersonDataLoader(PersonRepository personRepository, Faker faker) {
        this.personRepository = personRepository;
        this.faker = faker;
    }


    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading sample data...");
        List<Person> people = IntStream
                .rangeClosed(1, 100)
                .mapToObj(i -> new Person(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.phoneNumber().cellPhone(),
                        new Address(
                                faker.address().streetAddress(),
                                faker.address().city(),
                                faker.address().state(),
                                faker.address().zipCode())
                )).collect(Collectors.toList());
        personRepository.saveAll(people);

    }
}