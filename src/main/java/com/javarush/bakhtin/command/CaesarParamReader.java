package com.javarush.bakhtin.command;

import com.javarush.bakhtin.Console;

import java.nio.file.Path;

public class CaesarParamReader {

    private static final String keyInputMessage = "Введите ключ шифрования, по умолчанию - 1:";
    private static final String fromPathInputMessage = "Введите путь, откуда вы хотите считать данные или нажмите enter, чтобы использовать путь по умолчанию";
    private static final String toPathInputMessage = "Введите путь, куда вы хотите записать готовые данные или нажмите enter, чтобы использовать путь по умолчанию";
    private static final String dictPathInputMessage = "Введите путь к словарю или нажмите enter, чтобы выбрать dict.txt";
    private static final String encodedPathInputMessage = "Введите путь к файлу или нажмите enter, чтобы выбрать encrypted.txt";
    private static final String decodedPathInputMessage = "Введите путь к файлу или нажмите enter, чтобы выбрать decrypted.txt";
    private static int key = 1;
    private static final CaesarParamReader instance = new CaesarParamReader();

    public static CaesarParamReader getInstance() {
        return instance;
    }

    private Path checkForMessage(Path defaultPath) {
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
        System.out.println(fromPathInputMessage);
        return checkForMessage(defaultFrom);
    }

    public Path getToPathFromUser(Path defaultTo) {
        System.out.println(toPathInputMessage);
        return checkForMessage(defaultTo);
    }

    public Path getToDictFromUser(Path defaultDict) {
        System.out.println(dictPathInputMessage);
        return checkForMessage(defaultDict);
    }

    public Path getEncodedFromUser(Path defaultEncodedPath) {
        System.out.println(encodedPathInputMessage);
        return checkForMessage(defaultEncodedPath);
    }

    public Path getDecodedFromUser(Path defaultDecodedPath) {
        System.out.println(decodedPathInputMessage);
        return checkForMessage(defaultDecodedPath);
    }

}