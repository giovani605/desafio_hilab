package com.example.desafio.service;

import java.util.List;
import java.util.Optional;

import com.example.desafio.entity.Address;
import com.example.desafio.entity.Person;
import com.example.desafio.entity.Phone;
import com.example.desafio.repository.PersonRepository;
import com.example.desafio.util.CustomNotFoundException;
import com.example.desafio.util.UtilGeneral;

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

    private void validateAdress(Address address) throws Exception {

        if (address == null) {
            throw new Exception("Address can't be empty.");
        }
        if (!UtilGeneral.isValidString(address.getType())) {
            throw new Exception("Type is required.");
        }
        if (!UtilGeneral.isValidString(address.getZipcode())) {
            throw new Exception("Zipcode is required.");
        }
        if (!UtilGeneral.isValidZipcode(address.getZipcode())) {
            throw new Exception("A valid zipcode is required.");
        }
        if (!UtilGeneral.isValidString(address.getStreet())) {
            throw new Exception("Street is required.");
        }
        if (!UtilGeneral.isValidString(address.getNumber())) {
            throw new Exception("Number is required.");
        }

    }

    private void validatePhones(List<Phone> phones) throws Exception {
        if (phones.size() <= 0) {
            throw new Exception("At least one phone number is required.");
        }
        for (Phone phone : phones) {
            if (!UtilGeneral.isValidPhone(phone.getNumber())) {
                throw new Exception("Invalid phone: " + phone.getNumber());
            }
        }
    }

    private void validatePerson(Person person) throws Exception {

        if (!UtilGeneral.isValidString(person.getStatus())) {
            throw new Exception("Status is required.");
        }
        if (!UtilGeneral.isValidString(person.getFamilyName())) {
            throw new Exception("Family name is required.");
        }
        if (!UtilGeneral.isValidString(person.getGivenName())) {
            throw new Exception("Given name is required.");
        }
        if (!UtilGeneral.isValidString(person.getBirthDate())) {
            throw new Exception("Birth Date is required.");
        }

        validateAdress(person.getAddress());
        validatePhones(person.getPhones());

    }

    public Person save(Person person) throws Exception {
        validatePerson(person);
        try {
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
