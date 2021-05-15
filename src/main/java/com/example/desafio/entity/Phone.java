package com.example.desafio.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Phone implements Serializable {

    private static final long serialVersionUID = -7105409970622558953L;

    private String number;
}
