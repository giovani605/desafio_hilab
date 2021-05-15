package com.example.desafio.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = -7105409970622558954L;

    @Id
    private String id;

    public enum PersonStatus {
        ACTIVE, INACTIVE
    }

    private PersonStatus status;

    private String givenName;

    private String familyName;

    private Date birthDate;

    private Address address;

    private List<Phone> phones;

}
