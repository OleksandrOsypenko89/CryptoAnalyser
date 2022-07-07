package ru.javarush.cryptoanaliser.osypenko.application;

import ru.javarush.cryptoanaliser.osypenko.question.Question1;
import java.util.Scanner;

public class Application {

    public static Scanner scan() {
        return new Scanner(System.in);
    }
    public static void startApplication() {
        Question1.question();
    }
}
