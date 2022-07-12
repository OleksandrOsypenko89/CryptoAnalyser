package ru.javarush.cryptoanaliser.osypenko.commands;

import ru.javarush.cryptoanaliser.osypenko.scan.Application;
import ru.javarush.cryptoanaliser.osypenko.constants.Alphabet;
import ru.javarush.cryptoanaliser.osypenko.controller.QuestionExit;
import ru.javarush.cryptoanaliser.osypenko.exception.ApplicationException;

import java.io.*;

public class Decrypt {
    public static void decoder() {
        try {
            System.out.println("Укажите первый путь к файлу");
            FileInputStream fis = new FileInputStream(Application.scan().nextLine());
            Reader reader = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(reader);
            System.out.println("Укажите второй путь к файлу");
            Writer writer = new FileWriter(Application.scan().nextLine());
            System.out.println("Укажите число это будет ключ расшифровки");
            int key = Application.scan().nextInt();

            while (bufferedReader.ready()) {
                char[] value = bufferedReader.readLine().toCharArray();
                for (char c : value) {
                    for (int i = 0; i < Alphabet.fullAlphabet.length; i++) {
                        if (Alphabet.fullAlphabet[i] == c) {
                            int res = (i - key) % Alphabet.fullAlphabet.length;
                            if (res > 0) {
                                writer.write(Alphabet.fullAlphabet[res]);
                            } else {
                                writer.write(Alphabet.fullAlphabet[Alphabet.fullAlphabet.length - Math.abs(res) - 1]);
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
        } catch (IOException e) {
            throw new ApplicationException(e);
        }
        QuestionExit.questionExit();
    }
}
