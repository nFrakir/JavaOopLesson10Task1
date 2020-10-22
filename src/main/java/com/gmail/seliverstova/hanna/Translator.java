package com.gmail.seliverstova.hanna;

import java.io.IOException;

public class Translator {
    private Dictionary dict;

    public Translator(Dictionary dict) {
        super();
        this.dict = dict;
    }

    public Translator() {
        super();
    }

    public Dictionary getDict() {
        return dict;
    }

    public void setDict(Dictionary dict) {
        this.dict = dict;
    }

    public void loadDictionary(DictionaryDAO<Dictionary> dictDao) throws IOException {
        try {
            dict = dictDao.load();
        } catch (IOException e) {
            throw e;
        }
    }

    public void saveDictionary(DictionaryDAO<Dictionary> dictDao) throws IOException {
        try {
            dictDao.save(dict);
        } catch (IOException e) {
            throw e;
        }
    }

    public String translate(String text) {
        StringBuilder sb = new StringBuilder();
        String[] in = text.split(" ");
        String word = "";
        String tmp = "";
        for (String element : in) {
            String dot = "";
            if (element.contains(".")) {
                tmp = element.substring(0, element.lastIndexOf("."));
                dot = ".";
            } else if (element.contains(",")) {
                tmp = element.substring(0, element.lastIndexOf(","));
                dot = ",";
            } else {
                tmp = element;
            }
            word = dict.getDictionary().get(tmp);
            if (word != null) {
                sb.append(word + dot + " ");
            } else {
                sb.append(element + " ");
            }
        }
        return sb.toString();
    }
}
