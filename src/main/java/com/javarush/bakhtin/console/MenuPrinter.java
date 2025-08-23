package com.javarush.bakhtin.console;

import com.javarush.bakhtin.MenuController;
import com.javarush.bakhtin.command.MenuCommand;

import java.util.Map;

public class MenuPrinter {

    private static final String menuMessage = "Введите цифру, соответствующую команде:";

    protected static void print(){
        System.out.println(menuMessage);
        for (Map.Entry<Integer, MenuCommand> integerMenuCommandEntry : MenuController.menuItemMap.entrySet()) {
            System.out.print(integerMenuCommandEntry.getValue().getClass().getSimpleName());
            System.out.print( " - ");
            System.out.println(integerMenuCommandEntry.getKey());
        }
    }
}
