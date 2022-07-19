package ru.javarush.cryptoanaliser.osypenko.controller;

import ru.javarush.cryptoanaliser.osypenko.constants.ConstantText;
import ru.javarush.cryptoanaliser.osypenko.scan.Scan;

public class QuestionExit {
    public static void questionExit() {
        System.out.println(ConstantText.REPEAT + "\n" + ConstantText.TEXTQUESTIONEXIT + "\n" + ConstantText.REPEAT);
        while (true) {
            String numberFunction = Scan.scan().next();
            if (numberFunction.equalsIgnoreCase(ConstantText.MENU)) {
                QuestionStart.questionStart();
                break;
            } else if (numberFunction.equalsIgnoreCase(ConstantText.EXIT)) {
                System.out.println(ConstantText.GOODBYE);
                break;
            } else {
                System.err.println(ConstantText.NOTECORRECTY);
            }
        }
    }
}
