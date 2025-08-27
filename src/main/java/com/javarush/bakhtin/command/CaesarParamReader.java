package com.javarush.bakhtin.command;

import com.javarush.bakhtin.Console;

import java.nio.file.Path;

public class CaesarParamReader {

    private static final String keyInputMessage = "Введите ключ шифрования, по умолчанию - 1:";
    public static final String fromPathInputMessage = "Введите путь, откуда вы хотите считать данные или нажмите enter, чтобы использовать путь по умолчанию";
    public static final String toPathInputMessage = "Введите путь, куда вы хотите записать данные или нажмите enter, чтобы использовать путь по умолчанию";
    private static int key = 1;

    public static int getKeyFromUser() {
        System.out.print(keyInputMessage);
        int inputKey = Console.consoleInput.nextInt();
        if (inputKey != 0) {
            key = inputKey;
        }
        return key;
    }

    public static Path getFromPathFromUser(Path defaultFrom) {
        System.out.println(fromPathInputMessage);
        String consoleString = Console.consoleInput.nextLine();
        if (!consoleString.isEmpty()) {
            defaultFrom = Path.of(consoleString);
        }
        return defaultFrom;
    }

    public static Path getToPathFromUser(Path defaultFrom) {
        System.out.println(toPathInputMessage);
        String consoleString = Console.consoleInput.nextLine();
        if (!consoleString.isEmpty()) {
            defaultFrom = Path.of(consoleString);
        }
        return defaultFrom;
    }

}