package com.jionek.CRUDPeople.web.controller;

import com.jionek.CRUDPeople.business.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @GetMapping
    public String getPeople(Model model){
        List<Person> groupOfPeople = List.of(
                new Person(10L, "Jake", "Snake", LocalDate.of(1950, 2, 24), new BigDecimal(20000)),
                new Person(20L, "Sarah", "Smith", LocalDate.of(1960, 3, 23), new BigDecimal(30000)),
                new Person(30L, "John", "Jackson", LocalDate.of(1970, 4, 22), new BigDecimal(40000)),
                new Person(40L, "Bobby", "Black", LocalDate.of(1980, 5, 21), new BigDecimal(50000)),
                new Person(50L, "Kim", "Knot", LocalDate.of(1990, 6, 20), new BigDecimal(60000))
        );
        model.addAttribute("groupOfPeople", groupOfPeople);


        return "people";
    }
}
