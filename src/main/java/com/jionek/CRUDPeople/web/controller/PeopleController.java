package com.jionek.CRUDPeople.web.controller;

import com.jionek.CRUDPeople.business.model.Person;
import com.jionek.CRUDPeople.data.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {

   private PersonRepository personRepository;

    public PeopleController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @ModelAttribute("people")
    public Iterable<Person> getPeople(){
        return personRepository.findAll();
    }

    @GetMapping
    public String showPeoplePage(Model model){
        // THIS LIST IS CREATED IN PersonDataLoader class //
//        List<Person> groupOfPeople = List.of(
//                new Person(10L, "Jake", "Snake", LocalDate.of(1950, 2, 24), new BigDecimal(20000)),
//                new Person(20L, "Sarah", "Smith", LocalDate.of(1960, 3, 23), new BigDecimal(30000)),
//                new Person(30L, "John", "Jackson", LocalDate.of(1970, 4, 22), new BigDecimal(40000)),
//                new Person(40L, "Bobby", "Black", LocalDate.of(1980, 5, 21), new BigDecimal(50000)),
//                new Person(50L, "Kim", "Knot", LocalDate.of(1990, 6, 20), new BigDecimal(60000)),
//                new Person(60L, "Johnny", "Jenkis", LocalDate.of(2000, 7, 19), new BigDecimal(70000)),
//                new Person(70L, "Merry", "McGuire", LocalDate.of(2001, 8, 18), new BigDecimal(80000))
//        );
        // ATTRIBUTE IS SPECIFIED IN METHOD getPeople() //
//        model.addAttribute("groupOfPeople", groupOfPeople);
        return "people";
    }
}
