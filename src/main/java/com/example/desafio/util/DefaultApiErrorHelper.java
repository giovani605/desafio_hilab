package com.example.desafio.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefaultApiErrorHelper {

    private String mensagem;

    private Integer statusCode;

    private String statusCodeType;

}
