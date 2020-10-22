package com.gmail.seliverstova.hanna;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Dictionary implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, String> dictionary = new HashMap<>();

    public Dictionary(Map<String, String> dictionary) {
        super();
        this.dictionary = dictionary;
    }

    public Dictionary() {
        super();
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public String toString() {
        return "Dictionary [dictionary=" + dictionary + "]";
    }

    public void addEntry(String key, String value) {
        dictionary.put(key, value);
    }
}
