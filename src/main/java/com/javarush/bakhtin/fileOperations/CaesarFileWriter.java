package com.javarush.bakhtin.fileOperations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CaesarFileWriter {

    protected static java.io.FileWriter writer(Path toPath) throws IOException {
        try {
            if (!Files.exists(toPath)) {
                Files.createFile(toPath);
            }
            return new java.io.FileWriter(toPath.toFile());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error: file not found");
        }
    }
}
