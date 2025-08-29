package com.javarush.bakhtin.command;

import com.javarush.bakhtin.Caesar;

import java.nio.file.Path;

public class EncoderCommand implements MenuCommand {

    public void execute() {
        var reader = CaesarParamReader.getInstance();
        int key = reader.getKeyFromUser();
        Path from = reader.getFromPathFromUser(Constants.defaultTextPath);
        Path to = reader.getToPathFromUser(Constants.defaultEncodedPath);
        new Caesar().encode(key, from, to);
    }

}