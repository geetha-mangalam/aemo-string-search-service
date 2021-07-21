package com.company.stringsearch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.stringsearch.entity.Person;

/**
 * The Interface PersonRepository. For all persistent operations using JPA
 */
public interface PersonRepository extends JpaRepository<Person, String> {

}
