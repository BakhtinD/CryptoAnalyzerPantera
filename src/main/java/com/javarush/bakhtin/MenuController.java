package com.javarush.bakhtin;

import com.javarush.bakhtin.command.DecoderCommand;
import com.javarush.bakhtin.command.EncoderCommand;
import com.javarush.bakhtin.command.MenuCommand;

import java.util.HashMap;

public class MenuController {

    HashMap<Integer, MenuCommand> menuItemMap = new HashMap<>(3);

    public MenuController() {
        DecoderCommand decoderCommand = new DecoderCommand();
        EncoderCommand encoderCommand = new EncoderCommand();
        menuItemMap.put(0, decoderCommand);
        menuItemMap.put(1, encoderCommand);
    }

    public void control(int answer, int key) {
        menuItemMap.get(answer).execute(key);
    }
}
