package ru.javarush.cryptoanaliser.osypenko.controller;

import ru.javarush.cryptoanaliser.osypenko.scan.Scan;
import ru.javarush.cryptoanaliser.osypenko.commands.Analyze;
import ru.javarush.cryptoanaliser.osypenko.commands.BruteForce;
import ru.javarush.cryptoanaliser.osypenko.commands.Decrypt;
import ru.javarush.cryptoanaliser.osypenko.commands.Encrypt;

public class QuestionStart {
    public static void questionStart() {
        System.out.println("\u001b[34m" + "-".repeat(80));
        String textQuestion = """
                Выберете функцию которую Вы хотите выполнить?\s
                1. Шифровка текста\s
                2. Расшифровка текста с помощью ключа\s
                3. Расшифровка текста с помощью brute force (перебор всех вариантов)\s
                4. Расшифровка с помощью статистического анализа текста
                exit - для выхода из программы. (на любом этапе выполнения программы) \s
                menu - для возврата в главное меню. (на любом этапе выполнения программы) \s
                \nДля выбора введите соответствующий номер функции""";
        System.out.println(textQuestion);
        System.out.println("-".repeat(80) + "\u001b[0m");
        questionRun();
    }
    public static void questionRun() {
        while (true) {
            String numberFunction = Scan.scan().next();
            if (numberFunction.equals("1")) {
                System.out.println("\u001b[32;1mВы выбрали Шифрование текста \u001b[0m");
                Encrypt.encrypt();
                break;
            } else if (numberFunction.equals("2")) {
                System.out.println("\u001b[32;1mВы выбрали Дешифрование текста \u001b[0m");
                Decrypt.decrypt();
                break;
            } else if (numberFunction.equals("3")) {
                System.out.println("\u001b[32;1mВы выбрали Расшифровка текста с помощью brute force (перебор всех вариантов)\u001b[0m");
                BruteForce.bruteForce();
                break;
            } else if (numberFunction.equals("4")) {
                System.err.println("Извините но данная функция находится в разработке");
                Analyze.analyze();
                break;
            } else if (numberFunction.equalsIgnoreCase("exit")) {
                System.out.println("\u001b[32;1mДо скорой встречи \u001b[0m");
                break;
            } else if (numberFunction.equalsIgnoreCase("menu")) {
                System.out.println("\u001b[31;1mВы уже находитесь в главном меню. \u001b[0m");
            } else {
                System.out.println("\u001b[31;1mНе правильно введено значение. Повторите еще. \u001b[0m");
            }
        }
    }
}
