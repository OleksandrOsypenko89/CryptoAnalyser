package ru.javarush.cryptoanaliser.osypenko.commands;

import ru.javarush.cryptoanaliser.osypenko.application.Application;
import ru.javarush.cryptoanaliser.osypenko.constants.Alphabet;

import java.io.*;

public class Encoder {
    public static void encoder() {
        System.out.println("Укажите два пути к файлу");

        try (FileInputStream fis = new FileInputStream(Application.scan().nextLine());
             Reader reader = new InputStreamReader(fis);
             BufferedReader bufferedReader = new BufferedReader(reader);
             Writer writer = new FileWriter(Application.scan().nextLine())) {

            System.out.println("Укажите число это будет ключ шифрования");
            int key = Application.scan().nextInt();

            while (bufferedReader.ready()) {
                char[] value = bufferedReader.readLine().toCharArray();
                for (char c : value) {
                    for (int i = 0; i < Alphabet.fullAlphabet.length; i++) {
                        if (Alphabet.fullAlphabet[i] == c) {
                            writer.write(Alphabet.fullAlphabet[(i + key) % Alphabet.fullAlphabet.length]);
                        }
                    }
                }
                writer.write(Alphabet.JUMP);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


