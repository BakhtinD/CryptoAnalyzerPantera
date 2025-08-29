package com.javarush.bakhtin.command;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Constants {
    protected static Path defaultDictPath = Paths.get("text", "dict.txt");
    protected static Path defaultEncodedPath = Paths.get("text", "encrypted.txt");
    protected static Path defaultDecodedPath = Paths.get("text", "decrypted.txt");
    protected static Path defaultTextPath = Paths.get("text", "text.txt");
}