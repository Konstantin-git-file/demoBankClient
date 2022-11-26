package controller;

import model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repository.PersonRepository;

import java.util.List;

@Controller
@RequestMapping("/api/people")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
        }

//    @PostMapping("/putAll")
//    public List<Person> pullAll() {
//        var people = IntStream
//                .rangeClosed(1, 100)
//                .mapToObj(i -> new Person(
//                        faker.name().firstName(),
//                        faker.name().lastName(),
//                        faker.phoneNumber().cellPhone(),
//                        new Address(
//                                faker.address().streetAddress(),
//                                faker.address().city(),
//                                faker.address().state(),
//                                faker.address().zipCode())
//                )).collect(Collectors.toList());
//        return personRepository.saveAll(people);
//    }

    @GetMapping("/showAll")
    public List<Person> showAll() {
        return (List<Person>) personRepository.findAll();
    }


    @GetMapping("/findBy")
    public Person findByFirstAndLast(@RequestParam String first,
                                     @RequestParam String last) {
//        return personRepository.findByFirstNameEqualsAndLastNameEquals(first,last);
        return null;
    }
}