package com.javarush.bakhtin.command;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CaesarParamReader {

    private static final String keyInputMessage = "Введите ключ шифрования, по умолчанию - 1:";
    private static final String fromPathInputMessage = "Введите путь, откуда вы хотите считать данные или нажмите enter, чтобы выбрать ";
    private static final String dictPathInputMessage = "Введите путь к словарю или нажмите enter, чтобы выбрать ";
    private static final String encodedPathInputMessage = "Введите путь к зашифрованному файлу или нажмите enter, чтобы выбрать ";
    private static final String decodedPathInputMessage = "Введите путь к расшифрованному файлу или нажмите enter, чтобы выбрать ";
    private static final Path defaultDictPath = Path.of("text", "dict.txt");
    private static final Path defaultEncodedPath = Path.of("text", "encrypted.txt");
    private static final Path defaultDecodedPath = Paths.get("text", "decrypted.txt");

    private final Scanner consoleScanner = new Scanner(System.in);

    private static int key = 1;
    private static final CaesarParamReader instance = new CaesarParamReader();

    public static CaesarParamReader getInstance() {
        return instance;
    }

    private Path getPath(Path defaultPath) {
        String consoleString = consoleScanner.nextLine();
        if (!consoleString.isEmpty()) {
            return Path.of(consoleString);
        }
        return defaultPath;
    }

    protected int getKeyFromUser() {
        System.out.print(keyInputMessage);
        try {
            int inputKey = Integer.parseInt(consoleScanner.nextLine());
            if (inputKey != 0) {
                key = inputKey;
            }
            return key;
        } catch (NumberFormatException e) {
            // TODO Интерфейс польз должен быть на одном языке
            throw new RuntimeException("Error: not a number");
        }
    }

    protected Path getFromPathFromUser(Path defaultFrom) {
        System.out.println(fromPathInputMessage + defaultFrom.getFileName());
        return getPath(defaultFrom);
    }

    protected Path getDictFromUser() {
        System.out.println(dictPathInputMessage + defaultDictPath.getFileName());
        return getPath(defaultDictPath);
    }

    protected Path getEncodedFromUser() {
        System.out.println(encodedPathInputMessage + defaultEncodedPath.getFileName());
        return getPath(defaultEncodedPath);
    }

    protected Path getDecodedFromUser() {
        System.out.println(decodedPathInputMessage + defaultDecodedPath.getFileName());
        return getPath(defaultDecodedPath);
    }

}