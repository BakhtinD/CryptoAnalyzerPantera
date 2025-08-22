package com.javarush.bakhtin;

import com.javarush.bakhtin.exception.InvalidInputException;
import com.javarush.bakhtin.exception.WrongCommandException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    private static final String menuMessage = "Введите цифру, соответствующую команде:";
    private static final String encodeMessage = "Encode - 0";
    private static final String decodeMessage = "Decode - 1";
    private static final String keyInputMessage = "Введите ключ шифрования:";

    private final MenuController menuController = new MenuController();

    public void run() {
        while (true) {
            Scanner consoleInput = new Scanner(System.in);
            System.out.println(menuMessage);
            System.out.println(encodeMessage);
            System.out.println(decodeMessage);
            try {
                int answer = consoleInput.nextInt();
                System.out.print(keyInputMessage);
                int key = consoleInput.nextInt();
                menuController.control(answer, key);
                break;
            } catch (InputMismatchException e) {
                throw new InvalidInputException("Error: not a number");
            } catch (WrongCommandException e){
                System.err.println(e.getClass().getSimpleName());
                System.err.println(e.getMessage());
            }
        }
    }
}
