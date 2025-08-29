package com.javarush.bakhtin;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    private final MenuController menuController = new MenuController();
    public static final Scanner consoleInput = new Scanner(System.in);

    protected void run() {
        while (true) {
            menuController.printCommands();
            try {
                int answer = Integer.parseInt(consoleInput.nextLine());
                if (answer < 1 || answer > 4) throw new RuntimeException("Error: incorrect answer");
                menuController.executeCommand(answer);
            } catch (InputMismatchException e) {
                System.err.println("Error: not a number");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
