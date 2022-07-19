package ru.javarush.cryptoanaliser.osypenko.controller;

import ru.javarush.cryptoanaliser.osypenko.constants.ConstantText;
import ru.javarush.cryptoanaliser.osypenko.scan.Scan;
import ru.javarush.cryptoanaliser.osypenko.commands.Analyze;
import ru.javarush.cryptoanaliser.osypenko.commands.BruteForce;
import ru.javarush.cryptoanaliser.osypenko.commands.Decrypt;
import ru.javarush.cryptoanaliser.osypenko.commands.Encrypt;

public class QuestionStart {
    public static void questionStart() {
        System.out.println(ConstantText.REPEAT + "\n" + ConstantText.TEXTQUESTIONSTART + "\n" + ConstantText.REPEAT);
        questionRun();
    }

    public static void questionRun() {
        while (true) {
            String numberFunction = Scan.scan().next();
            if (numberFunction.equals("1")) {
                System.out.println(ConstantText.ONE);
                Encrypt.encrypt();
                break;
            } else if (numberFunction.equals("2")) {
                System.out.println(ConstantText.TWO);
                Decrypt.decrypt();
                break;
            } else if (numberFunction.equals("3")) {
                System.out.println(ConstantText.THREE);
                BruteForce.bruteForce();
                break;
            } else if (numberFunction.equals("4")) {
                System.err.println(ConstantText.FOUR);
                Analyze.analyze();
                break;
            } else if (numberFunction.equalsIgnoreCase(ConstantText.EXIT)) {
                System.out.println(ConstantText.GOODBYE);
                break;
            } else if (numberFunction.equalsIgnoreCase(ConstantText.MENU)) {
                System.err.println(ConstantText.ONTHEMENU);
            } else {
                System.err.println(ConstantText.NOTECORRECTY);
            }
        }
    }
}
