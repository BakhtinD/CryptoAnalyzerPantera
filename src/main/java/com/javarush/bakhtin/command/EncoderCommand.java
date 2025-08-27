package com.javarush.bakhtin.command;

import com.javarush.bakhtin.Caesar;

import java.nio.file.Path;
import java.nio.file.Paths;

public class EncoderCommand implements MenuCommand {

    Path defaultFromPath = Paths.get("text", "text.txt");
    Path defaultToPath = Paths.get("text", "encrypted.txt");

    public void execute() {
        var reader = CaesarParamReader.getInstance();
        int key = reader.getKeyFromUser();
        Path from = reader.getFromPathFromUser(defaultFromPath);
        Path to = reader.getToPathFromUser(defaultToPath);
        new Caesar().encode(key, from, to);
    }

}