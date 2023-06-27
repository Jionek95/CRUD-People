package com.jionek.CRUDPeople.data;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class PersonDataLoader implements ApplicationRunner {

    private PersonRepository personRepository;

    public PersonDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
    }
}
