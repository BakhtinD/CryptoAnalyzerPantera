package com.javarush.bakhtin;

public class Runner {
    public static void main(String[] args) {
        Console console = new Console();
        try {
            console.run();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println();
            console.run();
        }
    }
}