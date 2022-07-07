package ru.javarush.cryptoanaliser.osypenko.textencryption;

import ru.javarush.cryptoanaliser.osypenko.application.Application;
import ru.javarush.cryptoanaliser.osypenko.constants.Alphabet;
import ru.javarush.cryptoanaliser.osypenko.constants.Strings;

import java.io.*;

public class TextEncryption {
    public static void function1() {
        System.out.println(Strings.FUNCTION1 + Strings.FROM);

        try (FileInputStream fileInputStream = new FileInputStream(Application.scan().nextLine()); // D:\Testing\text.txt
             Reader reader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            System.out.println(Strings.ENCRYPTION);
            int key = Application.scan().nextInt();

            while (bufferedReader.ready()) {

                char[] bufferChar = bufferedReader.readLine().toCharArray();

                for (int i = 0; i < Alphabet.setAlphabet().length; i++) {
                    for (char c : bufferChar) {
                        if (Alphabet.setAlphabet()[i] == c) {
                            System.out.print(Alphabet.setAlphabet()[i + key]);
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
