package com.javarush.bakhtin;

import com.javarush.bakhtin.command.DecoderCommand;
import com.javarush.bakhtin.command.EncoderCommand;
import com.javarush.bakhtin.command.ExitCommand;
import com.javarush.bakhtin.command.MenuCommand;

import java.util.HashMap;

public class MenuController {

    public static HashMap<Integer, MenuCommand> menuItemMap = new HashMap<>(3);

    public MenuController() {
        DecoderCommand decoderCommand = new DecoderCommand();
        EncoderCommand encoderCommand = new EncoderCommand();
        ExitCommand exitCommand = new ExitCommand();
        menuItemMap.put(0, decoderCommand);
        menuItemMap.put(1, encoderCommand);
        menuItemMap.put(2, exitCommand);
    }

    public void control(int answer, int key) {
        menuItemMap.get(answer).execute(key);
    }
}
