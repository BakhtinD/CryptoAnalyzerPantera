package com.javarush.bakhtin;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class Caesar {

    private final int FIRST_UNICODE_LETTER = 9;
    private final int LAST_UNICODE_LETTER = 1104;
    private final int NUM_OF_UNICODE_LETTERS = LAST_UNICODE_LETTER - FIRST_UNICODE_LETTER;

    public void decode(int key, Path from, Path to) {
        encode(-key, from, to);
    }

    public void encode(int key, Path from, Path to) {
        FileSystem fileSystem = new FileSystem(from, to);
        try (FileReader reader = fileSystem.reader(); FileWriter writer = fileSystem.writer()) {
            while (reader.ready()) {
                int inputNum = reader.read();
                char resultChar = encodeChar(key, inputNum);
                writer.write(resultChar);
            }
            System.out.println("Выполнение завершено!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected char encodeChar(int key, int inputNum) {
        int resultNum = (inputNum - FIRST_UNICODE_LETTER + key % NUM_OF_UNICODE_LETTERS + NUM_OF_UNICODE_LETTERS) % NUM_OF_UNICODE_LETTERS + FIRST_UNICODE_LETTER;
        return (char) resultNum;
    }

}