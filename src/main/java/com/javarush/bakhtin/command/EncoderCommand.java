package com.javarush.bakhtin.command;

import com.javarush.bakhtin.Caesar;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EncoderCommand implements MenuCommand {

    private static final Path defaultTextPath = Paths.get("text", "text.txt");
    private static final String commandName = "Зашифровать";

    public String getCommandName() {
        return commandName;
    }

    public void execute() throws IOException {
        var reader = CaesarParamReader.getInstance();
        int key = reader.getKeyFromUser();
        Path from = reader.getFromPathFromUser(defaultTextPath);
        Path to = reader.getEncodedFromUser();

        new Caesar().encode(key, from, to);
    }

}