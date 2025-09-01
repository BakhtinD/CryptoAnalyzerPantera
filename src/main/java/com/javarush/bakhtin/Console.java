package com.javarush.bakhtin;

import java.util.InputMismatchException;

// FIXME ?? вообще не нужный класс
public class Console {

    private final MenuController menuController = new MenuController();

    protected void run() {
        while (true) {
            menuController.printCommands();
            try {
                int answer = menuController.getUserCommand();
                menuController.executeCommand(answer);
            } catch (InputMismatchException e) {
                System.err.println("Error: not a number");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
