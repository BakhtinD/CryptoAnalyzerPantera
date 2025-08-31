package com.javarush.bakhtin.fileOperations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CaesarFileReader {

    protected static java.io.FileReader reader(Path fromPath) throws IOException {
        try {
            if (!Files.exists(fromPath)) {
                Files.createFile(fromPath);
            }
            return new java.io.FileReader(fromPath.toFile());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error: file not found");
        }
    }

}
