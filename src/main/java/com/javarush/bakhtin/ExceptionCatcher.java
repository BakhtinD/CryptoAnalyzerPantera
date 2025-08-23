package com.javarush.bakhtin;

import com.javarush.bakhtin.console.Console;


public class ExceptionCatcher {
    public static void main(String[] args) {
        try {
            new Console().run();
        } catch (RuntimeException e){
            System.err.println(e.getMessage());
            System.out.println();
        }
    }
}
