package com.javarush.bakhtin.command;

import com.javarush.bakhtin.Caesar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForce implements MenuCommand {

    private static final String COMMAND_NAME = "Брутфорс";

    public String getCommandName() {
        return COMMAND_NAME;
    }

    private static final Pattern WORD_PATTERN = Pattern.compile("[а-я]{4,20}");

    private Set<String> wordSet = new HashSet<>();
    private Set<String> encodedWordSet = new HashSet<>();

    private final CaesarParamReader caesarParamReader = new CaesarParamReader();
    private final Caesar caesar = new Caesar();

    public void makeAWordListFromDictionary() throws IOException {
        String dict = Files.readString(caesarParamReader.getDictFromUser());
        Matcher matcher = WORD_PATTERN.matcher(dict);
        while (matcher.find()) {
            wordSet.add(matcher.group());
        }
    }

    private void makeAWordListFromDecodedFile(Path path) throws IOException {
        encodedWordSet.clear();
        String text = Files.readString(path);
        Matcher matcher = WORD_PATTERN.matcher(text);
        while (matcher.find()) {
            encodedWordSet.add(matcher.group());
        }
    }

    public void execute() throws IOException {
        makeAWordListFromDictionary();
        int maxNumOfMatches = 0;
        int shiftOfMaxNumOfMatches = 0;
        Path encodedPath = caesarParamReader.getEncodedFromUser();
        Path decodedPath = caesarParamReader.getDecodedFromUser();

        for (int shift = -50; shift <= 50; shift++) {
            System.out.println("Старт " + shift);
            caesar.decode(shift, encodedPath, decodedPath);
            makeAWordListFromDecodedFile(decodedPath);
            int findCounter = 0;
            for (String string : encodedWordSet) {
                if (wordSet.contains(string)) {
                    findCounter++;
                }
            }
            System.out.println("Стоп: найдено слов:" + findCounter);
            if (findCounter > maxNumOfMatches) {
                maxNumOfMatches = findCounter;
                shiftOfMaxNumOfMatches = shift;
            }
        }
        System.out.println("Правильный ключ: " + shiftOfMaxNumOfMatches);
        caesar.decode(shiftOfMaxNumOfMatches, encodedPath, decodedPath);
        System.out.println("Брутфорс завершен");
    }
}
