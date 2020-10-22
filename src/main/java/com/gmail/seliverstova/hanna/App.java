package com.gmail.seliverstova.hanna;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        String enFileName = "input/English.in";
        String ukrFileName = "input/Ukrainian.out";
        String dictFileName = "input/Dictionary.dat";

        createNewDictionary(dictFileName);

        try {
            DictionaryDAO<Dictionary> dictDao = new DictionaryDaoSerializableImplementation<>(new File(dictFileName));
            Translator tr = new Translator();
            tr.loadDictionary(dictDao);

            DictionaryConsole dictCon = new DictionaryConsole(tr.getDict());
            dictCon.inputDictionary();
            tr.saveDictionary(dictDao);

            System.out.println(tr.getDict());

            String text = FileManipulator.readText(new File(enFileName));
            String translation = tr.translate(text);
            FileManipulator.wrireToFile(new File(ukrFileName), translation);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createNewDictionary(String dictFileName) {
        Map<String, String> startDict = new HashMap<>();
        startDict.put("Little", "Маленький");
        startDict.put("boy", "хлопчик");
        startDict.put("loved", "любив");
        startDict.put("to", "");
        startDict.put("come", "приходити");
        startDict.put("and", "і");
        startDict.put("play", "грати");
        startDict.put("around", "навколо");
        startDict.put("tree", "дерева");
        startDict.put("every", "кожен");
        startDict.put("day", "день");
        startDict.put("apples", "яблука");

        try {
            DictionaryDAO<Dictionary> dictDao = new DictionaryDaoSerializableImplementation<>(new File(dictFileName));
            Translator tr = new Translator(new Dictionary(startDict));
            tr.saveDictionary(dictDao);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
