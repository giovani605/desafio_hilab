package com.example.desafio.controller;

import java.util.List;

import com.example.desafio.entity.Person;
import com.example.desafio.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getAll() throws Exception {
        List<Person> items = personService.findAll();
        if (items.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") String id) throws Exception {
        Person person = personService.findById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Add/Edit a person on database", notes = "For validantion porpuses, is necessary to send zipcode as \"99999-999\"  and phone numbers as \"(DD) 99999-9999\"")
    public ResponseEntity<Person> create(@RequestBody Person item) throws Exception {
        Person savedItem = personService.save(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id) throws Exception {
        Boolean sucess = personService.delete(id);
        return new ResponseEntity<Boolean>(sucess, HttpStatus.OK);
    }
}