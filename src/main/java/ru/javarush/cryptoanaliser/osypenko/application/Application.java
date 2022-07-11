package ru.javarush.cryptoanaliser.osypenko.application;

import ru.javarush.cryptoanaliser.osypenko.controller.QuestionStart;
import java.util.Scanner;

public class Application {
    public static void run() {
        QuestionStart.questionStart();
    }
    public static Scanner scan() {
        return new Scanner(System.in);
    }
}
