package com.javarush.bakhtin.command;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CaesarParamReader {

    private static final String KEY_INPUT_MESSAGE = "Введите ключ шифрования, по умолчанию - 1:";
    private static final String FROM_PATH_INPUT_MESSAGE = "Введите путь, откуда вы хотите считать данные или нажмите enter, чтобы выбрать ";
    private static final String DICT_PATH_INPUT_MESSAGE = "Введите путь к словарю или нажмите enter, чтобы выбрать ";
    private static final String ENCODED_PATH_INPUT_MESSAGE = "Введите путь к зашифрованному файлу или нажмите enter, чтобы выбрать ";
    private static final String DECODED_PATH_INPUT_MESSAGE = "Введите путь к расшифрованному файлу или нажмите enter, чтобы выбрать ";
    private static final Path DEFAULT_DICT_PATH = Path.of("text", "dict.txt");
    private static final Path DEFAULT_ENCODED_PATH = Path.of("text", "encrypted.txt");
    private static final Path DEFAULT_DECODED_PATH = Paths.get("text", "decrypted.txt");

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
        System.out.print(KEY_INPUT_MESSAGE);
        try {
            int inputKey = Integer.parseInt(consoleScanner.nextLine());
            if (inputKey != 0) {
                key = inputKey;
            }
            return key;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Ошибка, введите число");
        }
    }

    protected Path getFromPathFromUser(Path defaultFrom) {
        System.out.println(FROM_PATH_INPUT_MESSAGE + defaultFrom.getFileName());
        return getPath(defaultFrom);
    }

    protected Path getDictFromUser() {
        System.out.println(DICT_PATH_INPUT_MESSAGE + DEFAULT_DICT_PATH.getFileName());
        return getPath(DEFAULT_DICT_PATH);
    }

    protected Path getEncodedFromUser() {
        System.out.println(ENCODED_PATH_INPUT_MESSAGE + DEFAULT_ENCODED_PATH.getFileName());
        return getPath(DEFAULT_ENCODED_PATH);
    }

    protected Path getDecodedFromUser() {
        System.out.println(DECODED_PATH_INPUT_MESSAGE + DEFAULT_DECODED_PATH.getFileName());
        return getPath(DEFAULT_DECODED_PATH);
    }

}