package com.jionek.CRUDPeople.web.controller;

import com.jionek.CRUDPeople.business.model.Person;
import com.jionek.CRUDPeople.data.FileStorageRepository;
import com.jionek.CRUDPeople.data.PersonRepository;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/people")
@Log4j2
public class PeopleController {

    public static final String DISPO = """
             attachment; filename="%s"
            """;
    private PersonRepository personRepository;
    private FileStorageRepository fileStorageRepository;
    private PersonService personService;

    public PeopleController(PersonRepository personRepository, FileStorageRepository fileStorageRepository, PersonService personService) {
        this.personRepository = personRepository;
        this.fileStorageRepository = fileStorageRepository;
        this.personService = personService;
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

    @GetMapping("/images/{resourcePath}")
    public ResponseEntity<Resource> getResource(@PathVariable String resourcePath){
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, String.format(DISPO, resourcePath))
                .body(fileStorageRepository.findByName(resourcePath));
    }

    @PostMapping
    public String savePerson(@Valid Person person, Errors errors, @RequestParam("fileName") MultipartFile photoFile) throws IOException {
        log.info(person);
        log.info("File name: " + photoFile.getOriginalFilename());
        log.info("File size: " + photoFile.getSize());
        log.info("Errors: " + errors);
        if (!errors.hasErrors()) {
            fileStorageRepository.save(photoFile.getOriginalFilename(), photoFile.getInputStream());
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
