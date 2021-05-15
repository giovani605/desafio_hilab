package com.example.desafio.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Address implements Serializable {

    private boolean type;

    private String zipcode;

    private String state;

    private String city;

    private Integer number;

    private String complement;

    private String district;

}
