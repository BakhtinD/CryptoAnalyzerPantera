package com.javarush.bakhtin.command;

public class ExitCommand implements MenuCommand {
    public void execute() {
        System.out.print("Выход из программы...");
        System.exit(0);
    }
}
