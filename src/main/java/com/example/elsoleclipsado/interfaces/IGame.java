package com.example.elsoleclipsado.interfaces;

public interface IGame {
    boolean guessLetter(char letter);
    void useHelp();
    boolean gameFinished();
    int getRemainingAttempts();
    int getHelpUses();
    String getProgress();
}
