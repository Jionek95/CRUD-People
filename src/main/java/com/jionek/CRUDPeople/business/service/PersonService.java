package com.jionek.CRUDPeople.business.service;

import com.jionek.CRUDPeople.business.model.Person;
import com.jionek.CRUDPeople.data.FileStorageRepository;
import com.jionek.CRUDPeople.data.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final FileStorageRepository storageRepository;

    public PersonService(PersonRepository personRepository, FileStorageRepository storageRepository) {
        this.personRepository = personRepository;
        this.storageRepository = storageRepository;
    }

    @Transactional
    public Person save(Person person, InputStream photoStream) {
        Person savedPerson = personRepository.save(person);
        storageRepository.save(person.getFileName(), photoStream);
        return savedPerson;
    }

    public Optional<Person> findById(Long aLong) {
        return personRepository.findById(aLong);
    }

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public void deleteAllById(Iterable<Long> ids) {
        Iterable<Person> peopleToDelete = personRepository.findAllById(ids);
        Stream<Person> peopleStream = StreamSupport.stream(peopleToDelete.spliterator(), true);
        Set<String> fileNames = peopleStream
                .map(Person::getFileName)
                .collect(Collectors.toSet());
        personRepository.deleteAllById(ids);
        storageRepository.deleteAllByNames(fileNames);
    }
}
