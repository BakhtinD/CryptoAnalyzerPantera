package com.javarush.bakhtin.command;

import java.io.IOException;

public interface MenuCommand {

    String getCommandName();

    void execute() throws IOException;
}
