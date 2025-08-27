package com.javarush.bakhtin;

import com.javarush.bakhtin.command.*;

import java.util.HashMap;

public class MenuController {

    private static final String menuMessage = "Введите цифру, соответствующую команде:";
    private static final HashMap<Integer, MenuCommand> menuItemMap = new HashMap<>(3);


    public MenuController() {
        DecoderCommand decoderCommand = new DecoderCommand();
        EncoderCommand encoderCommand = new EncoderCommand();
        ExitCommand exitCommand = new ExitCommand();
        menuItemMap.put(1, encoderCommand);
        menuItemMap.put(2, decoderCommand);
        menuItemMap.put(3, exitCommand);
    }

    public void executeCommand(int answer) {
        menuItemMap.get(answer).execute();
    }

    public void printCommands() {
        System.out.println(menuMessage);
        for (var menuItem : MenuController.menuItemMap.entrySet()) {
            System.out.print(menuItem.getValue().getClass().getSimpleName());
            System.out.print(" - ");
            System.out.println(menuItem.getKey());
        }
    }

}
