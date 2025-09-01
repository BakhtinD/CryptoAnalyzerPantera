package com.javarush.bakhtin.command;

import com.javarush.bakhtin.Caesar;

import java.io.IOException;
import java.nio.file.Path;

public class DecoderCommand implements MenuCommand {

    private static final String COMMAND_NAME = "Расшифровать";

    public String getCommandName() {
        return COMMAND_NAME;
    }

    public void execute() throws IOException {
        var reader = CaesarParamReader.getInstance();
        int key = reader.getKeyFromUser();
        Path from = reader.getEncodedFromUser();
        Path to = reader.getDecodedFromUser();
        new Caesar().decode(key, from, to);
    }

}
