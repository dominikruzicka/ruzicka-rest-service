package com.dominik.restservices.services;

public class ErrorResponse implements Response{

    private String errorMessage = "Operation failed";

    public String getErrorMessage() {
        return errorMessage;
    }
}
