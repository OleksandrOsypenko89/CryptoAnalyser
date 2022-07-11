package ru.javarush.cryptoanaliser.osypenko.controller;

import ru.javarush.cryptoanaliser.osypenko.application.Application;
import ru.javarush.cryptoanaliser.osypenko.commands.Analyze;
import ru.javarush.cryptoanaliser.osypenko.commands.BruteForce;
import ru.javarush.cryptoanaliser.osypenko.commands.Decoder;
import ru.javarush.cryptoanaliser.osypenko.commands.Encoder;

public class QuestionStart {
    public static void questionStart() {
        System.out.println("\u001b[34m" + "-".repeat(70));
        String textQuestion = """
                Выберете функцию которую Вы хотите выполнить?\s
                1. Шифровка текста\s
                2. Расшифровка текста с помощью ключа\s
                3. Расшифровка текста с помощью brute force (перебор всех вариантов)\s
                4. Расшифровка с помощью статистического анализа текста
                5. Выйти
                \nДля выбора введите соответствующий номер функции""";
        System.out.println(textQuestion);
        System.out.println("-".repeat(70) + "\u001b[0m");

        while (true) {
            String numberFunction = Application.scan().next();
            //noinspection IfCanBeSwitch
            if (numberFunction.equals("1")) {
                Encoder.encoder();
                break;
            } else if (numberFunction.equals("2")) {
                Decoder.decoder();
                break;
            } else if (numberFunction.equals("3")) {
                System.err.println("Извините но данная функция находится в разработке");
                BruteForce.bruteForce();
                break;
            } else if (numberFunction.equals("4")) {
                System.err.println("Извините но данная функция находится в разработке");
                Analyze.analyze();
                break;
            } else if (numberFunction.equals("5")) {
                System.out.println("\u001b[32;1m До скорой встречи \u001b[0m");
                break;
            } else {
                System.out.print("\u001b[31;1m Не правильно введено значение. Повторите еще. \u001b[0m");
            }
        }
    }
}
