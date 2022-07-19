package ru.javarush.cryptoanaliser.osypenko.constants;

public class ConstantText {
    public static final String ENTERTHEADDRESS = "Укажите путь к файлу или нажмите Enter для получения доступа к корневому файлу";
    public static final String GOODBYE = "До скорой встречи";
    public static final String NOTENTEREDCORRECTY = "По данному адресу файл не найден. Введите еще раз!";
    public static final String NOTECORRECTY = "Ошибка ввода. Повторите еще!";
    public static final String MENU = "menu";
    public static final String EXIT = "exit";
    public static final String NUMBERKEYE = "Укажите число это будет ключ для шифрования или нажмите Enter для случайного подбора ключа";
    public static final String NUMBERKEYD = "Укажите ключ для розшифрования";
    public static final String TEXT = "text.txt";
    public static final String ENCRYPTNAMEFILE = "encrypt.txt";
    public static final String DECRYPTNAMEFILE = "decrypt.txt";
    public static final String BRUTEFORCENAMEFILE = "bruteForce.txt";
    public static final String REPEAT = "-".repeat(90);
    public static final String TEXTQUESTIONSTART = """
                Выберете функцию которую Вы хотите выполнить?\s
                1 - Шифровка текста\s
                2 - Расшифровка текста с помощью ключа\s
                3 - Расшифровка текста с помощью brute force (перебор всех вариантов)\s
                4 - Расшифровка с помощью статистического анализа текста
                exit - для выхода из программы. (на любом этапе выполнения программы) \s
                menu - для возврата в главное меню. (на любом этапе выполнения программы) \s
                \nДля выбора введите соответствующий номер функции""";
    public static final String TEXTQUESTIONEXIT = """
                Выберете команду которую Вы хотите выполнить?\s
                menu - что бы Продолжить\s
                exit - что бы Выйти\s
                \nДля выбора введите соответствующую команду""";

    public static final String ONE = "Вы выбрали Шифрование текста";
    public static final String TWO = "Вы выбрали Расшифровка текста с помощью ключа";
    public static final String THREE = "Вы выбрали Расшифровка текста с помощью brute force (перебор всех вариантов)";
    public static final String FOUR = "Вы выбрали Расшифровка с помощью статистического анализа текста \nИзвините но данная функция находится в разработке";
    public static final String ONTHEMENU = "Вы уже находитесь в главном меню.";
}
