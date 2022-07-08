package ru.javarush.cryptoanaliser.osypenko.question;

import ru.javarush.cryptoanaliser.osypenko.application.Application;
import ru.javarush.cryptoanaliser.osypenko.constants.Strings;
import ru.javarush.cryptoanaliser.osypenko.textencryption.TextEncryption;

public class StartQuestion {
    public static void question() {
        System.out.println(Strings.HELLO + "\n" +
                Strings.FUNCTION1 + "\n" +
                Strings.FUNCTION2 + "\n" +
                Strings.FUNCTION3 + "\n" +
                Strings.FUNCTION4);

        System.out.println("\n" + Strings.QUESTIONFUNCTION);

        while (true) {
            String numberFunction = Application.scan().next();
            //noinspection IfCanBeSwitch
            if (numberFunction.equals("1")) {
                TextEncryption.function1();
                break;
            } else if (numberFunction.equals("2")) {
                System.out.print(Strings.FUNCTION2);
                break;
            } else if (numberFunction.equals("3")) {
                System.out.print(Strings.FUNCTION3);
                break;
            } else if (numberFunction.equals("4")) {
                System.out.print(Strings.FUNCTION4);
                break;
            } else {
                System.out.print(Strings.INCORRECT);
            }
        }
    }
}
