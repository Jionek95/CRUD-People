package com.jionek.CRUDPeople.data;

import com.jionek.CRUDPeople.business.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query(nativeQuery = true, value = "SELECT file_name FROM person WHERE id IN: ids")
    public Set<String> findFileNameByIds(@Param("ids") Iterable<Long> ids);

}
