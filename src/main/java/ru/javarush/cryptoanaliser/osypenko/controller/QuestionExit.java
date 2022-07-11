package ru.javarush.cryptoanaliser.osypenko.controller;

import ru.javarush.cryptoanaliser.osypenko.application.Application;

public class QuestionExit {
    public static void questionExit(){
        System.out.print("\u001b[34m" + "-".repeat(70));
        String textQuestion = """
                \nВыберете функцию которую Вы хотите выполнить?\s
                1. Продолжить\s
                2. Выйти\s
                \nДля выбора введите соответствующий номер функции""";
        System.out.println(textQuestion);
        System.out.println("-".repeat(70) + "\u001b[0m");
        while(true) {
            String numberFunction = Application.scan().next();
            //noinspection IfCanBeSwitch
            if (numberFunction.equals("1")) {
                QuestionStart.questionStart();
                break;
            } else if (numberFunction.equals("2")) {
                System.out.println("\u001b[32;1m До скорой встречи \u001b[0m");
                break;
            } else {
                System.out.print("\u001b[31;1m Не правильно введено значение. Повторите еще. \u001b[0m");
            }
        }
    }
}
