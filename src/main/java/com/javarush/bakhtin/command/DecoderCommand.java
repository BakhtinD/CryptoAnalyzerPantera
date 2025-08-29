package com.javarush.bakhtin.command;

import com.javarush.bakhtin.Caesar;

import java.nio.file.Path;

public class DecoderCommand implements MenuCommand {

    public void execute() {
        var reader = CaesarParamReader.getInstance();
        int key = reader.getKeyFromUser();
        Path from = reader.getFromPathFromUser(Constants.defaultEncodedPath);
        Path to = reader.getToPathFromUser(Constants.defaultDecodedPath);
        new Caesar().decode(key, from, to);
    }

}
