package com.javarush.bakhtin;

import java.util.InputMismatchException;
import java.util.Scanner;

// TODO вообще не нужный класс
public class Console {

    private final MenuController menuController = new MenuController();
    // TODO плохо public
    public static final Scanner consoleInput = new Scanner(System.in);

    protected void run() {
        while (true) {
            menuController.printCommands();
            try {
                // TODO menuController.getUserCommand
                int answer = Integer.parseInt(consoleInput.nextLine());
                if (answer < 1 || answer > 4) {
                    throw new RuntimeException("Error: incorrect answer");
                }

                menuController.executeCommand(answer);
            } catch (InputMismatchException e) {
                System.err.println("Error: not a number");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
