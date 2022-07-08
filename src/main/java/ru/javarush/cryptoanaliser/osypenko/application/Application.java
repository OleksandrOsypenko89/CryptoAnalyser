package ru.javarush.cryptoanaliser.osypenko.application;

import ru.javarush.cryptoanaliser.osypenko.question.StartQuestion;
import java.util.Scanner;

public class Application {

    public static Scanner scan() {
        return new Scanner(System.in);
    }
    public static void startApplication() {
        StartQuestion.question();
    }
}
