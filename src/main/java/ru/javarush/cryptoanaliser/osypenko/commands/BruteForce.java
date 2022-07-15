package ru.javarush.cryptoanaliser.osypenko.commands;

import ru.javarush.cryptoanaliser.osypenko.constants.Alphabet;
import ru.javarush.cryptoanaliser.osypenko.controller.QuestionExit;
import ru.javarush.cryptoanaliser.osypenko.controller.QuestionStart;
import ru.javarush.cryptoanaliser.osypenko.exception.ApplicationException;
import ru.javarush.cryptoanaliser.osypenko.scan.Scan;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce {
    public static void bruteForce() {
        try {
            while (true) {
                System.out.println("Укажите путь к файлу или нажмите Enter для получения доступа к корневому файлу");
                String text = Scan.scan().nextLine();
                if (text.equalsIgnoreCase("exit")) {
                    System.out.println("До скорой встречи");
                    break;
                } else if (text.equalsIgnoreCase("menu")) {
                    QuestionStart.questionStart();
                    break;
                }
                Path inPath = Path.of(text);

                if (Files.exists(inPath)) {
                    FileInputStream fis1 = new FileInputStream(text);
                    Reader reader1 = new InputStreamReader(fis1);
                    BufferedReader bufferedReader1 = new BufferedReader(reader1);

                    String[] keyWord = new String[]{"нет", "как", "или", "все", "это", "вам"};

                    int num = 0;
                    String temp = "";
                    int key = 0;

                    while (num < Alphabet.fullAlphabet.length) {
                        while (bufferedReader1.ready()) {
                        char[] value = bufferedReader1.readLine().toCharArray();
                        for (char c : value) {
                            for (int i = 0; i < Alphabet.fullAlphabet.length; i++) {
                                if (Alphabet.fullAlphabet[i] == c) {
                                    int res = (i - num) % Alphabet.fullAlphabet.length;


                                    if (res > Alphabet.fullAlphabet.length) { //???
                                        res = Alphabet.fullAlphabet[Alphabet.fullAlphabet.length - Math.abs(res)];
                                    }
                                    char[] t = new char[Alphabet.fullAlphabet[res]];
                                    temp = String.valueOf(t);
                                }
                            }
                        }
                        String[] a = temp.split(" ");
                        for (String b : a) {
                            if (b.equalsIgnoreCase(keyWord[0]) ||
                                    b.equalsIgnoreCase(keyWord[1]) ||
                                    b.equalsIgnoreCase(keyWord[2]) ||
                                    b.equalsIgnoreCase(keyWord[3]) ||
                                    b.equalsIgnoreCase(keyWord[4]) ||
                                    b.equalsIgnoreCase(keyWord[5])) {
                                key = num;
                                break;
                            }
                        }
                        }
                        num++;
                    }
                    fis1.close();
                    reader1.close();
                    bufferedReader1.close();

                    System.out.println(temp);

                    FileInputStream fis2 = new FileInputStream(text);
                    Reader reader2 = new InputStreamReader(fis2);
                    BufferedReader bufferedReader2 = new BufferedReader(reader2);
                    Writer writer = new FileWriter(inPath.getParent() + File.separator + "bruteforce.txt");

                    while (bufferedReader2.ready()) {
                        char[] value = bufferedReader2.readLine().toCharArray();
                        for (char c : value) {
                            for (int i = 0; i < Alphabet.fullAlphabet.length; i++) {
                                if (Alphabet.fullAlphabet[i] == c) {
                                    int res = (i - key) % Alphabet.fullAlphabet.length;
                                    if (res > 0) {
                                        writer.write(Alphabet.fullAlphabet[res]);
                                    } else {
                                        writer.write(Alphabet.fullAlphabet[Alphabet.fullAlphabet.length - Math.abs(res)]);
                                    }
                                }
                            }
                        }
                        writer.write(Alphabet.JUMP);
                    }

                    fis2.close();
                    reader2.close();
                    bufferedReader2.close();
                    writer.close();
                    System.out.println("Выполнено! \nСоздан файл bruteforce.txt по адресу " + inPath.getParent());

                    QuestionExit.questionExit();
                } else if (Files.isDirectory(inPath) || !Files.exists(inPath)) {
                    System.err.println("По данному адресу файл не найден. Введите еще раз!");
                    Decrypt.decrypt();
                }
                break;
            }
        } catch (IOException e) {
            throw new ApplicationException(e);
        }
    }
}
