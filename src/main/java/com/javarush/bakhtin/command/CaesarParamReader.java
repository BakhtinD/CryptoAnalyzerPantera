package com.javarush.bakhtin.command;

import com.javarush.bakhtin.Console;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CaesarParamReader {

    private static final String keyInputMessage = "Введите ключ шифрования, по умолчанию - 1:";
    private static final String fromPathInputMessage = "Введите путь, откуда вы хотите считать данные или нажмите enter, чтобы выбрать ";
    private static final String dictPathInputMessage = "Введите путь к словарю или нажмите enter, чтобы выбрать ";
    private static final String encodedPathInputMessage = "Введите путь к зашифрованному файлу или нажмите enter, чтобы выбрать ";
    private static final String decodedPathInputMessage = "Введите путь к расшифрованному файлу или нажмите enter, чтобы выбрать ";
    private static final Path defaultDictPath = Path.of("text", "dict.txt");
    private static final Path defaultEncodedPath = Path.of("text", "encrypted.txt");
    private static final Path defaultDecodedPath = Paths.get("text", "decrypted.txt");

    private static int key = 1;
    private static final CaesarParamReader instance = new CaesarParamReader();

    public static CaesarParamReader getInstance() {
        return instance;
    }

    private Path getPath(Path defaultPath) {
        String consoleString = Console.consoleInput.nextLine();
        if (!consoleString.isEmpty()) {
            defaultPath = Path.of(consoleString);
        }
        return defaultPath;
    }

    public int getKeyFromUser() {
        System.out.print(keyInputMessage);

        try {
            int inputKey = Integer.parseInt(Console.consoleInput.nextLine());
            if (inputKey != 0) {
                key = inputKey;
            }
            return key;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Error: not a number");
        }
    }

    public Path getFromPathFromUser(Path defaultFrom) {
        System.out.println(fromPathInputMessage + defaultFrom.getFileName());
        return getPath(defaultFrom);
    }

    public Path getDictFromUser() {
        System.out.println(dictPathInputMessage + defaultDictPath.getFileName());
        return getPath(defaultDictPath);
    }

    public Path getEncodedFromUser() {
        System.out.println(encodedPathInputMessage + defaultEncodedPath.getFileName());
        return getPath(defaultEncodedPath);
    }

    public Path getDecodedFromUser() {
        System.out.println(decodedPathInputMessage + defaultDecodedPath.getFileName());
        return getPath(defaultDecodedPath);
    }

}