package com.acgnfuns.repository;

import com.acgnfuns.domain.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;


/**
 * Repository can be used to delegate CRUD operations against the data source: http://goo.gl/P1J8QH
 */
public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {
    @Override
    Optional<Person> findById(Integer id);
}
