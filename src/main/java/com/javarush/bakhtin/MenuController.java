package com.javarush.bakhtin;

import com.javarush.bakhtin.command.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class MenuController {

    private static final Scanner consoleInput = new Scanner(System.in);

    private static final String MENU_MESSAGE = "Введите цифру, соответствующую команде:";
    private static final HashMap<Integer, MenuCommand> menuItemMap = new HashMap<>(3);

    protected MenuController() {
        menuItemMap.put(1, new EncoderCommand());
        menuItemMap.put(2, new DecoderCommand());
        menuItemMap.put(3, new BruteForce());
        menuItemMap.put(4, new ExitCommand());
    }

    protected void executeCommand(int answer) throws IOException {
        menuItemMap.get(answer).execute();
    }

    protected void printCommands() {
        System.out.println(MENU_MESSAGE);
        for (var menuItem : MenuController.menuItemMap.entrySet()) {
            System.out.print(menuItem.getValue().getCommandName());
            System.out.print(" - ");
            System.out.println(menuItem.getKey());
        }
    }

    public int getUserCommand() {
        int answer = Integer.parseInt(consoleInput.nextLine());
        if (answer < 1 || answer > 4) {
            throw new RuntimeException("Ошибка, введите число от 1 до 4");
        }
        return answer;
    }
}
