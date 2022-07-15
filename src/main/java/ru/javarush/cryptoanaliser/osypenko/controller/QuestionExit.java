package ru.javarush.cryptoanaliser.osypenko.controller;

import ru.javarush.cryptoanaliser.osypenko.scan.Scan;

public class QuestionExit {
    public static void questionExit() {
        System.out.print("-".repeat(80));
        String textQuestion = """
                \nВыберете команду которую Вы хотите выполнить?\s
                menu что бы Продолжить\s
                exit что бы Выйти\s
                \nДля выбора введите соответствующую команду""";
        System.out.println(textQuestion);
        System.out.println("-".repeat(80));
        while (true) {
            String numberFunction = Scan.scan().next();
            if (numberFunction.equalsIgnoreCase("menu")) {
                QuestionStart.questionStart();
                break;
            } else if (numberFunction.equalsIgnoreCase("exit")) {
                System.out.println("До скорой встречи");
                break;
            } else {
                System.err.println("Не правильно введено значение. Повторите еще.");
            }
        }
    }
}
