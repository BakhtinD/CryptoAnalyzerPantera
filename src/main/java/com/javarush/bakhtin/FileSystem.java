package com.javarush.bakhtin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSystem {

    Path fromPath;
    Path toPath;

    public FileSystem(Path fromPath, Path toPath) {
        this.fromPath = fromPath;
        this.toPath = toPath;
    }

    public FileReader reader() {
        try {
            if (!Files.exists(fromPath)) {
                Files.createFile(fromPath);
            }
            return new FileReader(fromPath.toFile());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error: file not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public FileWriter writer() {
        try {
            if (!Files.exists(toPath)) {
                Files.createFile(toPath);
            }
            return new FileWriter(toPath.toFile());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error: file not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
