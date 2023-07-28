package com.jionek.CRUDPeople.data;

import com.jionek.CRUDPeople.business.model.Person;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class PersonDataLoader implements ApplicationRunner {
    private PersonRepository personRepository;

    public PersonDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (personRepository.count() == 0) {
            List<Person> groupOfPeople = List.of(
                    new Person(null, "Jake", "Joke", LocalDate.of(1950, 2, 24), new BigDecimal(20000), "jake@joke.com"),
                    new Person(null, "Sarah", "Smith", LocalDate.of(1960, 3, 23), new BigDecimal(30000), "sarah@smith.com"),
                    new Person(null, "John", "Jackson", LocalDate.of(1970, 4, 22), new BigDecimal(40000), "john@jackson.com"),
                    new Person(null, "Bobby", "Black", LocalDate.of(1980, 5, 21), new BigDecimal(50000), "bobby@black.com"),
                    new Person(null, "Kim", "Knot", LocalDate.of(1990, 6, 20), new BigDecimal(60000), "kim@knot.com"),
                    new Person(null, "Johnny", "Jenkis", LocalDate.of(2000, 7, 19), new BigDecimal(70000), "johnny@jenkis.com"),
                    new Person(null, "Merry", "McGuire", LocalDate.of(2001, 8, 18), new BigDecimal(80000), "merry@mcGuire.com")
            );
            personRepository.saveAll(groupOfPeople);
        }
    }
}
