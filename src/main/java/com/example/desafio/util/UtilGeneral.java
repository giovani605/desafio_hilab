package com.example.desafio.util;

public class UtilGeneral {

    public static boolean isValidString(Object value) {
        if (value == null) {
            return false;
        } else {
            return isValidString(value.toString());
        }
    }

    public static boolean isValidString(String value) {
        return value != null || ("").equals(value);
    }

    public static boolean isValidPhone(String phoneNumber) {
        String regex = "[(][0-9]{2}[)] [0-9]?[0-9]{4}[-]?[0-9]{4}";
        return phoneNumber.matches(regex);
    }

    public static boolean isValidZipcode(String zipcode) {
        String regex = "[0-9]{5}-[0-9]{3}";
        return zipcode.matches(regex);
    }

}
