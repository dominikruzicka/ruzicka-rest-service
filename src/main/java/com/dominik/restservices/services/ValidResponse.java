package com.dominik.restservices.services;

public class ValidResponse implements Response{

    private String message = "Operation successful";

    public String getMessage() {
        return message;
    }

}
