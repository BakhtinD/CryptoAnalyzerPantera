package com.javarush.bakhtin.command;

import com.javarush.bakhtin.Caesar;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DecoderCommand implements MenuCommand {

    Path defaultFromPath = Paths.get("text", "encrypted.txt");
    Path defaultToPath = Paths.get("text", "decrypted.txt");

    public void execute() {
        int key = CaesarParamReader.getKeyFromUser();
        Path from = CaesarParamReader.getFromPathFromUser(defaultFromPath);
        Path to = CaesarParamReader.getToPathFromUser(defaultToPath);
        new Caesar().decode(key, from, to);
    }
}
