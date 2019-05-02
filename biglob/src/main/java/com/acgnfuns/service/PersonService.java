package com.acgnfuns.service;

import com.acgnfuns.domain.Person;
import com.acgnfuns.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;

    public PersonService() {
    }

    @Transactional
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Person getPersonById(Integer id) {
        return personRepository.findById(id).orElse(null);
    }
}
