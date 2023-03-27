package com.spring.sample.accessing.jpa.data.rest.person.repository;

import java.util.List;

import com.spring.sample.accessing.jpa.data.rest.person.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>, CrudRepository<Person, Long> {

    List<Person> findByLastName(@Param("name") String name);

}
