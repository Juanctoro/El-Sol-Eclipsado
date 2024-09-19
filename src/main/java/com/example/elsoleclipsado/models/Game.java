package com.example.elsoleclipsado.models;

import com.example.elsoleclipsado.interfaces.IGame;

public class Game implements IGame {
    private final SecretWord secretWord;
    private int attemptsRemaining;
    private int helpUses;
    private boolean gameFinished;

    public Game(String secretWord) {
        this.secretWord = new SecretWord(secretWord);
        this.attemptsRemaining = 5;
        this.helpUses = 3;
        this.gameFinished = false;
    }
    @Override
    public boolean guessLetter(char letter) {
        if (gameFinished) {
            return false;
        }

        boolean isCorrect = secretWord.checkLetter(letter);
        if (!isCorrect) {
            attemptsRemaining--;
            if (attemptsRemaining == 0) {
                gameFinished = true;
            }
        }
        return isCorrect;
    }

    @Override
    public void useHelp() {
        if (helpUses > 0) {
            secretWord.checkLetter(secretWord.getLetter());
            helpUses--;
        }
    }

    @Override
    public boolean gameFinished() {
        return gameFinished;
    }

    @Override
    public int getRemainingAttempts() {
        return attemptsRemaining;
    }

    @Override
    public int getHelpUses() {
        return helpUses;
    }

    @Override
    public String getProgress() {
        return secretWord.getProgress();
    }
}
