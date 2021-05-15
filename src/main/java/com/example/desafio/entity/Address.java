package com.example.desafio.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Address implements Serializable {

    private static final long serialVersionUID = -7105409970622558913L;

    public enum AddressType {
        PHYSICAL, DELIVERY
    }

    private AddressType type;

    private String zipcode;

    private String state;

    private String street;

    private String city;

    private Integer number;

    private String complement;

    private String district;

}
