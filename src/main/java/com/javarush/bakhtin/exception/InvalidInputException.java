package com.javarush.bakhtin.exception;

import java.util.InputMismatchException;

public class InvalidInputException extends InputMismatchException {
    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String message) {
        super(message);
    }

}
