package com.example.elsoleclipsado.models;

import com.example.elsoleclipsado.interfaces.ISecretWord;

import java.util.Arrays;


public class SecretWord implements ISecretWord {
    private final String word;
    private final char[] progress;

    public SecretWord(String word) {
        this.word = word;
        this.progress = new char[word.length()];
        Arrays.fill(progress, '_');
    }

    @Override
    public boolean checkLetter(char letter) {
        boolean correct = false;

        letter = Character.toLowerCase(letter);

        for (int i = 0; i < word.length(); i++) {
            char letterWord = Character.toLowerCase(word.charAt(i));

            if (letterWord == letter || noAccent(letterWord) == letter || letter == withAccent(letterWord)) {
                progress[i] = word.charAt(i);
                correct = true;
            }
        }
        return correct;
    }

    @Override
    public Character getLetter(){
        for (int i = 0; i < progress.length; i++) {
            if (progress[i] == '_') {
                return word.charAt(i);
            }
        }
        return null;
    }

    @Override
    public String getProgress() {
        return new String(progress);
    }

    private char noAccent(char c) {
        return switch (c) {
            case 'á', 'Á' -> 'a';
            case 'é', 'É' -> 'e';
            case 'í', 'Í' -> 'i';
            case 'ó', 'Ó' -> 'o';
            case 'ú', 'Ú' -> 'u';
            default -> (c);
        };
    }

    private char withAccent(char c) {
        return switch (c) {
            case 'a', 'A' -> 'á';
            case 'e', 'E' -> 'é';
            case 'i', 'I' -> 'í';
            case 'o', 'O' -> 'ó';
            case 'u', 'U' -> 'ú';
            case 'ñ', 'Ñ' -> 'ñ';
            default -> (c);
        };
    }
}
