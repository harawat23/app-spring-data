package com.example.appspringdata;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public Iterable<Person> getMethodName() {
        return personRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Person> getPersonByName(@PathVariable String id) {
        return personRepository.findById(id);
    }
}
