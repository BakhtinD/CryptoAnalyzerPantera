package com.javarush.bakhtin.command;

import com.javarush.bakhtin.Caesar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForce implements MenuCommand {

    public static final Pattern PATTERN = Pattern.compile("[а-я]{4,20}");

    Set<String> wordSet = new HashSet<>();
    Set<String> encodedWordList = new HashSet<>(); // TODO сделать обратно set

    CaesarParamReader caesarParamReader = new CaesarParamReader();
    Caesar caesar = new Caesar();

    Path dictPath = caesarParamReader.getToDictFromUser(Constants.defaultDictPath);
    Path encodedPath = caesarParamReader.getEncodedFromUser(Constants.defaultEncodedPath);
    Path decodedPath = caesarParamReader.getDecodedFromUser(Constants.defaultDecodedPath);

    public void makeAWordList() {
        try {
            String dict = Files.readString(dictPath);
            Matcher matcher = PATTERN.matcher(dict);
            while (matcher.find()) {
                wordSet.add(dict.substring(matcher.start(), matcher.end()));
            }
            System.out.println("wordList size " + wordSet.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void makeAWordListFromDecodedFile(Path path) {
        try {
            encodedWordList.clear();
            String text = new String(Files.readAllBytes(path));
            Matcher matcher = PATTERN.matcher(text);
            while (matcher.find()) {
                encodedWordList.add(text.substring(matcher.start(), matcher.end()));
            }
            System.out.println("encodedWordList size " + encodedWordList.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void execute() {
        makeAWordList();
        System.out.println("Введите данные для шифрования данных");
        new EncoderCommand().execute();
        int maxNumOfMatches = 0;
        int shiftOfMaxNumOfMatches = 0;
        for (int shift = -5; shift <= 5; shift++) {
            System.out.println("Старт " + shift);
            caesar.decode(shift, encodedPath, decodedPath);
            makeAWordListFromDecodedFile(decodedPath);
            int findCounter = 0;
            for (String string : encodedWordList) {
                if (wordSet.contains(string)) {
                    findCounter++;
                }
            }
            System.out.println("Стоп: найдено слов:" + findCounter);
            if (findCounter > maxNumOfMatches) maxNumOfMatches = findCounter;
            shiftOfMaxNumOfMatches = shift;
        }
        System.out.println(shiftOfMaxNumOfMatches);
        caesar.decode(shiftOfMaxNumOfMatches, encodedPath, decodedPath);
        System.out.println("Брутфорс завершен");
        System.out.println();
    }
}
