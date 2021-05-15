package com.example.desafio.service;

import java.util.List;
import java.util.Optional;

import com.example.desafio.entity.Person;
import com.example.desafio.repository.PersonRepository;
import com.example.desafio.util.CustomNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll() throws Exception {
        return personRepository.findAll();
    }

    public Person findById(String id) throws Exception {
        Optional<Person> personOptinal = personRepository.findById(id);
        if (!personOptinal.isPresent()) {
            throw new CustomNotFoundException("Person not found.");
        }
        return personOptinal.get();
    }

    private void validatePerson(Person person) throws Exception {

    }

    public Person save(Person person) throws Exception {
        try {
            validatePerson(person);
            personRepository.save(person);
            return person;
        } catch (Exception e) {
            throw new Exception("Unable to save person.");
        }
    }

    public Boolean delete(String id) throws Exception {
        this.findById(id);
        try {
            personRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception("Unable to delete person.");
        }
    }

}
