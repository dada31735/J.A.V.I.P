package com.dada31735.JAVIP.service.exceptions;

//Just to serve as a reminder to add exceptions and that they should be checked
public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}
