package ru.javarush.cryptoanaliser.osypenko.application;

import ru.javarush.cryptoanaliser.osypenko.controller.Controller;
import java.util.Scanner;

public class Application {
    public static void run() {
        Controller.question();
    }
    public static Scanner scan() {
        return new Scanner(System.in);
    }
}
