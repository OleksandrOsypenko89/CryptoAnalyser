package ru.javarush.cryptoanaliser.osypenko.controller;

import ru.javarush.cryptoanaliser.osypenko.application.Application;
import ru.javarush.cryptoanaliser.osypenko.commands.Encoder;

public class Controller {
    public static String textQuestion = """
                Какую функцию Вы хотите выполнить?\s
                1. Шифровка текста\s
                2. Расшифровка текста с помощью ключа\s
                3. Расшифровка текста с помощью brute force (перебор всех вариантов)\s
                4. Расшифровка с помощью статистического анализа текста
                5. Выйти
                \nДля выбора введите соответствующий номер функции""";
    public static void question() {
        System.out.println(textQuestion);

        while (true) {
            String numberFunction = Application.scan().next();
            //noinspection IfCanBeSwitch
            if (numberFunction.equals("1")) {
                Encoder.encoder();
                break;
            } else if (numberFunction.equals("2")) {
                break;
            } else if (numberFunction.equals("3")) {
                break;
            } else if (numberFunction.equals("4")) {
                break;
            } else if (numberFunction.equals("5")){
                System.out.println("Пока!");
                // Функция для остановки программы
            } else {
                System.out.print("\nНе правильно введено значение. Повторите еще.\n");
            }
        }
    }
}
