package com.javarush.bakhtin;

import com.javarush.bakhtin.fileOperations.FileSystem;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class Caesar {

    private final int FIRST_UNICODE_LETTER = 9;
    private final int LAST_UNICODE_LETTER = 1104;
    private final int NUM_OF_UNICODE_LETTERS = LAST_UNICODE_LETTER - FIRST_UNICODE_LETTER;

    public void decode(int key, Path from, Path to) throws IOException {
        encode(-key, from, to);
    }

    public void encode(int key, Path from, Path to) throws IOException {
        FileSystem fileSystem = new FileSystem(from, to);
        try (FileReader reader = fileSystem.reader(); FileWriter writer = fileSystem.writer()) {
            while (reader.ready()) {
                int inputUnicodeCode = reader.read();
                char resultChar = encodeChar(key, inputUnicodeCode);
                writer.write(resultChar);
            }
        }
    }

    protected char encodeChar(int key, int unicodeCode) {
        return (char) ((unicodeCode - FIRST_UNICODE_LETTER + key % NUM_OF_UNICODE_LETTERS + NUM_OF_UNICODE_LETTERS)
                % NUM_OF_UNICODE_LETTERS + FIRST_UNICODE_LETTER); // Общая формула для циклического сдвига
    }

}