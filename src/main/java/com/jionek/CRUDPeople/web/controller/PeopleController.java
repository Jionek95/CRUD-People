package com.jionek.CRUDPeople.web.controller;

import com.jionek.CRUDPeople.business.model.Person;
import com.jionek.CRUDPeople.data.PersonRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {

   private PersonRepository personRepository;

    public PeopleController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @ModelAttribute("groupOfPeople")
    public Iterable<Person> getPeople(){
        return personRepository.findAll();
    }

    @ModelAttribute("person")
    public Person getPerson(){
        return new Person();
    }

    @GetMapping
    public String showPeoplePage(){
        return "people";
    }

    @PostMapping
    public String savePerson(@Valid Person person, Errors errors){
        System.out.println(person);
        if (!errors.hasErrors()) {
            personRepository.save(person);
            return "redirect:people";
        }
        return "people";
    }
}
