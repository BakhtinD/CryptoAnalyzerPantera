package com.javarush.bakhtin.console;

import com.javarush.bakhtin.MenuController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    private final MenuController menuController = new MenuController();
    private static final String keyInputMessage = "Введите ключ шифрования:";

    public void run() {
        Scanner consoleInput = new Scanner(System.in);
        MenuPrinter.print();
        try {
            int answer = consoleInput.nextInt();
            if (answer<0 || answer>2) throw new RuntimeException("Error: incorrect answer");
            System.out.print(keyInputMessage);
            int key = consoleInput.nextInt();
            menuController.control(answer, key);

        } catch (InputMismatchException e) {
            throw new RuntimeException("Error: not a number");
        }

    }
}
