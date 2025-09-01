package com.javarush.bakhtin.command;

import com.javarush.bakhtin.Caesar;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EncoderCommand implements MenuCommand {

    private static final Path DEFAULT_TEXT_PATH = Paths.get("text", "text.txt");
    private static final String COMMAND_NAME = "Зашифровать";

    public String getCommandName() {
        return COMMAND_NAME;
    }

    public void execute() throws IOException {
        var reader = CaesarParamReader.getInstance();
        int key = reader.getKeyFromUser();
        Path from = reader.getFromPathFromUser(DEFAULT_TEXT_PATH);
        Path to = reader.getEncodedFromUser();

        new Caesar().encode(key, from, to);
    }

}