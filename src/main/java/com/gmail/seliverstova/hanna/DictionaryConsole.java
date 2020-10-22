package com.gmail.seliverstova.hanna;

import java.util.Scanner;

public class DictionaryConsole {
    private Dictionary dict;

    public DictionaryConsole(Dictionary dict) {
        super();
        this.dict = dict;
    }

    public DictionaryConsole() {
        super();
    }

    public void inputDictionary() {
        Scanner sc = new Scanner(System.in);
        String inKey = "";
        String inValue = "";

        for (; inKey != null;) {
            System.out.println("Input key or 0 for exit");
            inKey = sc.nextLine();

            System.out.println("Input value or 0 for exit");
            inValue = sc.nextLine();

            if ((inKey.equals("0")) || (inValue.equals("0"))) {
                inKey = null;
            } else {
                dict.addEntry(inKey, inValue);
                System.out.println("Entry was added to dictionary");
            }
        }
        sc.close();
    }
}
