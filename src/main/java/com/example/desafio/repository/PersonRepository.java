package com.example.desafio.repository;

import com.example.desafio.entity.Person;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {

}
