package com.jionek.CRUDPeople.data;

import com.jionek.CRUDPeople.business.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
