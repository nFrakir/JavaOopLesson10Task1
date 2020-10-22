package com.gmail.seliverstova.hanna;

import java.io.*;

public class FileManipulator {
    public static void wrireToFile(File file, String text) throws IOException {
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.print(text);
        } catch (IOException e) {
            throw e;
        }
    }

    public static String readText(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(; ((line = br.readLine()) != null);) {
                sb.append(line);
            }
        } catch (IOException e) {
            throw e;
        }

        return sb.toString();
    }
}
