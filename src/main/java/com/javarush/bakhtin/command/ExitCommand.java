package com.javarush.bakhtin.command;

public class ExitCommand implements MenuCommand {

    private static final String commandName = "Выход из программы";

    public String getCommandName() {
        return commandName;
    }

    public void execute() {
        System.out.print("Выход из программы...");
        System.exit(0);
    }
}