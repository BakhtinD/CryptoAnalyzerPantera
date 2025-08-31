package com.javarush.bakhtin.fileOperations;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class FileSystem {

    private Path fromPath;
    private Path toPath;

    public FileSystem(Path fromPath, Path toPath) {
        this.fromPath = fromPath;
        this.toPath = toPath;
    }

    public FileReader reader() throws IOException {
        return CaesarFileReader.reader(fromPath);
    }

    public FileWriter writer() throws IOException {
        return CaesarFileWriter.writer(toPath);
    }

}
