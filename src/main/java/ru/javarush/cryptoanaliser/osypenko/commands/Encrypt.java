package ru.javarush.cryptoanaliser.osypenko.commands;

import ru.javarush.cryptoanaliser.osypenko.controller.QuestionExit;
import ru.javarush.cryptoanaliser.osypenko.scan.Scan;
import ru.javarush.cryptoanaliser.osypenko.constants.Alphabet;
import ru.javarush.cryptoanaliser.osypenko.controller.QuestionStart;
import ru.javarush.cryptoanaliser.osypenko.exception.ApplicationException;
import ru.javarush.cryptoanaliser.osypenko.util.PathFinder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Encrypt {
    public static void encrypt() {
        try {
            while (true) {
                System.out.println("Укажите путь к файлу или нажмите Enter для получения доступа к корневому файлу");
                String text = Scan.scan().nextLine();
                Path inPath;
                if (!text.equals("")) {
                    if (text.equalsIgnoreCase("exit")) {
                        System.out.println("До скорой встречи");
                        break;
                    } else if (text.equalsIgnoreCase("menu")) {
                        QuestionStart.questionStart();
                        break;
                    }
                    inPath = Path.of(text);
                } else {
                    inPath = Path.of(PathFinder.getRoot() + "text.txt");
                }

                if (Files.exists(inPath)) {
                    FileInputStream fis = new FileInputStream(String.valueOf(inPath));
                    Reader reader = new InputStreamReader(fis);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    Writer writer = new FileWriter(inPath.getParent() + File.separator + "encrypt.txt");

                    System.out.println("Укажите число это будет ключ шифрования");
                    String num = Scan.scan().next();
                    if (num.equalsIgnoreCase("exit")) {
                        System.out.println("До скорой встречи");
                        break;
                    } else if (num.equalsIgnoreCase("menu")) {
                        QuestionStart.questionStart();
                        break;
                    }
                    int key = Integer.parseInt(num);

                    while (bufferedReader.ready()) {
                        char[] value = bufferedReader.readLine().toCharArray();
                        for (char c : value) {
                            for (int i = 0; i < Alphabet.fullAlphabet.length; i++) {
                                if (Alphabet.fullAlphabet[i] == c) {
                                    int res = (i + key) % Alphabet.fullAlphabet.length;
                                    if (res < Alphabet.fullAlphabet.length) {
                                        writer.write(Alphabet.fullAlphabet[res]);
                                    } else {
                                        writer.write(Alphabet.fullAlphabet[res - Alphabet.fullAlphabet.length]);
                                    }
                                }
                            }
                        }
                        writer.write(Alphabet.JUMP);
                    }

                    fis.close();
                    reader.close();
                    bufferedReader.close();
                    writer.close();
                    System.out.println("Выполнено! \nСоздан файл encrypt.txt по адресу " + inPath.getParent());

                    QuestionExit.questionExit();
                } else if (Files.isDirectory(inPath) || !Files.exists(inPath)) {
                    System.err.println("По данному адресу файл не найден. Введите еще раз!");
                    Encrypt.encrypt();
                }
                break;
            }
        } catch (IOException e) {
            throw new ApplicationException(e);
        }
    }
}


