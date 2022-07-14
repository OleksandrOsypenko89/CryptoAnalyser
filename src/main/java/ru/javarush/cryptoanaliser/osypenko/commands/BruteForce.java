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
                System.out.println("Укажите путь к файлу");
                String text = Scan.scan().nextLine();
                if (text.equalsIgnoreCase("exit")) {
                    break;
                } else if (text.equalsIgnoreCase("menu")) {
                    QuestionStart.questionStart();
                    break;
                }
                Path inPath = Path.of(text);

                if (Files.exists(inPath)) {
                    FileInputStream fis = new FileInputStream(text);
                    FileInputStream fis1 = new FileInputStream(text);

                    Reader reader = new InputStreamReader(fis);
                    Reader reader1 = new InputStreamReader(fis1);

                    BufferedReader bufferedReader = new BufferedReader(reader);
                    BufferedReader bufferedReader1 = new BufferedReader(reader1);

                    Writer writer = new FileWriter(inPath.getParent() + File.separator + "bruteforce.txt");

                    String[] keyWord = new String[]{"нет", "как", "или", "все", "это", "вам"};

                    int num = 20;
                    String temp;
                    int key = 0;

                    while (num < Alphabet.fullAlphabet.length) {
                        while (bufferedReader.ready()) {
                            temp = bufferedReader.readLine();
                            char[] value = temp.toCharArray();
                            for (char c : value) {
                                for (int i = 0; i < Alphabet.fullAlphabet.length; i++) {
                                    if (Alphabet.fullAlphabet[i] == c) {
                                        int res = (i - num) % Alphabet.fullAlphabet.length;
                                        if (res < 0) {
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

                    while (bufferedReader1.ready()) {
                        char[] value = bufferedReader1.readLine().toCharArray();
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

                    fis.close();
                    fis1.close();
                    reader.close();
                    reader1.close();
                    bufferedReader.close();
                    bufferedReader1.close();
                    writer.close();
                    System.out.println("\u001b[32;1mВыполнено! \nСоздан файл \u001b[0mbruteforce.txt \u001b[32;1mпо адресу\u001b[0m " + inPath.getParent());

                    QuestionExit.questionExit();
                } else if (Files.isDirectory(inPath) || !Files.exists(inPath)) {
                    System.out.println("\u001b[31;1mПо данному адресу файл не найден. Введите еще раз! \u001b[0m");
                    Decrypt.decrypt();
                }
                break;
            }
        } catch (IOException e) {
            throw new ApplicationException(e);
        }
    }
}
