package com.javarush.bakhtin;

import com.javarush.bakhtin.exception.InvalidInputException;

public class ExceptionCatcher {
    public static void main(String[] args) {
        try {
            new Console().run();
        } catch (InvalidInputException e){
            System.err.println(e.getClass().getSimpleName());
            System.err.println(e.getMessage());
        }
    }
}
