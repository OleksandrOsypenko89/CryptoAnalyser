package ru.javarush.cryptoanaliser.osypenko.commands;

import ru.javarush.cryptoanaliser.osypenko.constants.Alphabet;
import ru.javarush.cryptoanaliser.osypenko.constants.ConstantText;
import ru.javarush.cryptoanaliser.osypenko.controller.QuestionExit;
import ru.javarush.cryptoanaliser.osypenko.controller.QuestionStart;
import ru.javarush.cryptoanaliser.osypenko.exception.ApplicationException;
import ru.javarush.cryptoanaliser.osypenko.scan.Scan;
import ru.javarush.cryptoanaliser.osypenko.util.PathFinder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce {
    public static void bruteForce() {
        try {
            while (true) {
                System.out.println(ConstantText.ENTERTHEADDRESS);
                String scanRes = Scan.scan().nextLine();
                Path inPath;
                if (!scanRes.equals("")) {
                    if (scanRes.equalsIgnoreCase(ConstantText.EXIT)) {
                        System.out.println(ConstantText.GOODBYE);
                        break;
                    } else if (scanRes.equalsIgnoreCase(ConstantText.MENU)) {
                        QuestionStart.questionStart();
                        break;
                    }
                    inPath = Path.of(scanRes);
                } else {
                    inPath = Path.of(PathFinder.getRoot() + ConstantText.ENCRYPTNAMEFILE);
                }

                if (Files.exists(inPath)) {
                    String[] keyWord = new String[]{"нет", "как", "или", "все", "это", "вам"};
                    int num = 0;
                    boolean flag = true;

                    while (num < Alphabet.fullAlphabet.length) {
                        FileInputStream fis1 = new FileInputStream(String.valueOf(inPath));
                        Reader reader1 = new InputStreamReader(fis1);
                        BufferedReader bufferedReader1 = new BufferedReader(reader1);
                        Writer writer1 = new FileWriter(inPath.getParent() + File.separator + ConstantText.BRUTEFORCENAMEFILE);
                        while (bufferedReader1.ready()) {
                            String temp = bufferedReader1.readLine();
                            char[] value = temp.toCharArray();

                            for (char c : value) {
                                for (int i = 0; i < Alphabet.fullAlphabet.length; i++) {
                                    if (Alphabet.fullAlphabet[i] == c) {
                                        int res = (i - num) % Alphabet.fullAlphabet.length;
                                        if (res > 0) {
                                            writer1.write(Alphabet.fullAlphabet[res]);
                                        } else {
                                            writer1.write(Alphabet.fullAlphabet[152 - Math.abs(res)]);
                                        }
                                    }
                                }
                            }
                            writer1.write(Alphabet.JUMP);
                        }
                        fis1.close();
                        reader1.close();
                        bufferedReader1.close();
                        writer1.close();

                        FileInputStream fis2 = new FileInputStream(String.valueOf(Path.of(PathFinder.getRoot() + ConstantText.BRUTEFORCENAMEFILE)));
                        Reader reader2 = new InputStreamReader(fis2);
                        BufferedReader bufferedReader2 = new BufferedReader(reader2);
                        while (bufferedReader2.ready()) {
                            String[] str = bufferedReader2.readLine().split("\"");
                            for (String b : str) {
                                if (b.equalsIgnoreCase(keyWord[0]) ||
                                        b.equalsIgnoreCase(keyWord[1]) ||
                                        b.equalsIgnoreCase(keyWord[2]) ||
                                        b.equalsIgnoreCase(keyWord[3]) ||
                                        b.equalsIgnoreCase(keyWord[4])) {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        fis2.close();
                        reader2.close();
                        bufferedReader2.close();
                        if (!flag) {
                            break;
                        }
                        num++;
                    }
                    System.out.println("Выполнено! \nСоздан файл " + ConstantText.BRUTEFORCENAMEFILE + " по адресу " + inPath.getParent() + File.separator);

                    QuestionExit.questionExit();
                } else if (Files.isDirectory(inPath) || !Files.exists(inPath)) {
                    System.err.println(ConstantText.NOTENTEREDCORRECTY);
                    BruteForce.bruteForce();
                }
                break;
            }
        } catch (IOException e) {
            throw new ApplicationException(e);
        }
    }
}
