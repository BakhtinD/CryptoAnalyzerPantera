package com.javarush.bakhtin.command;

import com.javarush.bakhtin.Caesar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForce implements MenuCommand {

    // TODO меньше public - private
    // TODO что за pattern - WORD_PATTERN
    public static final Pattern PATTERN = Pattern.compile("[а-я]{4,20}");

    // TODO меньше public - private
    Set<String> wordSet = new HashSet<>();
    Set<String> encodedWordSet = new HashSet<>();

    // TODO меньше public - private
    final CaesarParamReader caesarParamReader = new CaesarParamReader();
    final Caesar caesar = new Caesar();

    // TODO rename сделать список слов из словаря
    public void makeAWordList() {
        try {
            String dict = Files.readString(caesarParamReader.getDictFromUser());
            Matcher matcher = PATTERN.matcher(dict);
            while (matcher.find()) {
                // TODO use matcher.group()
                wordSet.add(dict.substring(matcher.start(), matcher.end()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void makeAWordListFromDecodedFile(Path path) {
        try {
            encodedWordSet.clear();
            // TODO readString
            String text = new String(Files.readAllBytes(path));
            Matcher matcher = PATTERN.matcher(text);
            while (matcher.find()) {
                // TODO use matcher.group()
                encodedWordSet.add(text.substring(matcher.start(), matcher.end()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void execute() {
        makeAWordList();
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
        System.out.println(shiftOfMaxNumOfMatches);
        caesar.decode(shiftOfMaxNumOfMatches, encodedPath, decodedPath);
        System.out.println("Брутфорс завершен");
    }
}
