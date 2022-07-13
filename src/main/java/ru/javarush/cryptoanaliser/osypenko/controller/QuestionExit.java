package ru.javarush.cryptoanaliser.osypenko.controller;

import ru.javarush.cryptoanaliser.osypenko.scan.Scan;

public class QuestionExit {
    public static void questionExit() {
        System.out.print("\u001b[34m" + "-".repeat(70));
        String textQuestion = """
                \nВыберете команду которую Вы хотите выполнить?\s
                menu что бы Продолжить\s
                exit что бы Выйти\s
                \nДля выбора введите соответствующую команду""";
        System.out.println(textQuestion);
        System.out.println("-".repeat(70) + "\u001b[0m");
        while (true) {
            String numberFunction = Scan.scan().next();
            if (numberFunction.equalsIgnoreCase("menu")) {
                QuestionStart.questionStart();
                break;
            } else if (numberFunction.equalsIgnoreCase("exit")) {
                System.out.println("\u001b[32;1mДо скорой встречи \u001b[0m");
                break;
            } else {
                System.out.println("\u001b[31;1mНе правильно введено значение. Повторите еще. \u001b[0m");
            }
        }
    }
}
