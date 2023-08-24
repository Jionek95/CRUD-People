package com.jionek.CRUDPeople.web.controller;

import com.jionek.CRUDPeople.business.model.Person;
import com.jionek.CRUDPeople.data.PersonRepository;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/people")
@Log4j2
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
    public Person showPerson(){
        return new Person();
    }

    @GetMapping
    public String showPeoplePage(){
        return "people";
    }

    @PostMapping
    public String savePerson(@Valid Person person, Errors errors, @RequestParam MultipartFile fileName){
        log.info(person);
        log.info("File name: " + fileName.getOriginalFilename());
        log.info("File size: " + fileName.getSize());
        log.info("Errors: " + errors);
        if (!errors.hasErrors()) {
            personRepository.save(person);
            return "redirect:people";
        }
        return "people";
    }

    @PostMapping(params = "deleteOperation=true")
    public String deletePerson(@RequestParam("checkboxes") Optional<List<Long>> selections){
        log.info(selections);
        if (selections.isPresent()) {
            personRepository.deleteAllById(selections.get());
        }
        return "redirect:people";
    }

    @PostMapping(params = "editOperation=true")
    public String editPerson(@RequestParam("checkboxes") Optional<List<Long>> selections, Model model){
        log.info(selections);
        if (selections.isPresent()) {
            Optional<Person> personToEdit = personRepository.findById(selections.get().get(0));// for multiple chosen people option, we take first
            model.addAttribute("person", personToEdit);
        }
        return "people";
    }
}
