package com.javarush.bakhtin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtil {

    public static FileWriter toFileWriter(Path toPath) throws IOException {
        try {
            if (!Files.exists(toPath)) {
                Files.createFile(toPath);
            }
            return new FileWriter(toPath.toFile());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Ошибка, файл не найден");
        }
    }

    public static FileReader toFileReader(Path fromPath){
        try {
            return new FileReader(fromPath.toFile());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Ошибка, файл не найден");
        }
    }

}
