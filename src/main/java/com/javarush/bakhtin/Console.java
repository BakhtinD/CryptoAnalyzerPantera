package com.javarush.bakhtin;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    private final MenuController menuController = new MenuController();
    public static Scanner consoleInput = new Scanner(System.in);

    public void run() {
        while (true) {
            menuController.printCommands();
            try {
                int answer = consoleInput.nextInt();
                if (answer < 1 || answer > 3) throw new RuntimeException("Error: incorrect answer");
                menuController.executeCommand(answer);
            } catch (InputMismatchException e) {
                throw new RuntimeException("Error: not a number");
            }
        }
    }
}
