package com.javarush.bakhtin.command;

public class ExitCommand implements MenuCommand{
    @Override
    public void execute(int key) {
        System.out.print("Выход из программы...");
    }
}
