package com.javarush.bakhtin.command;

public class ExitCommand implements MenuCommand {

    private static final String COMMAND_NAME = "Выход из программы";

    public String getCommandName() {
        return COMMAND_NAME;
    }

    public void execute() {
        System.out.print("Выход из программы...");
        System.exit(0);
    }
}