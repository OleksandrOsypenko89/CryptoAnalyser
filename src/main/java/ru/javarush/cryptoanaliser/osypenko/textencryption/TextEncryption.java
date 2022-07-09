package ru.javarush.cryptoanaliser.osypenko.textencryption;

import ru.javarush.cryptoanaliser.osypenko.application.Application;
import ru.javarush.cryptoanaliser.osypenko.constants.Alphabet;
import ru.javarush.cryptoanaliser.osypenko.constants.Strings;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

public class TextEncryption {
    public static void function1() {
        System.out.println(Strings.FROM);

        Path path = Path.of(Application.scan().nextLine());

        try (FileChannel fileChannel = FileChannel.open(path)) {
            ByteBuffer inBuffer = ByteBuffer.allocate(64);

            System.out.println(Strings.ENCRYPTION);
            int key = Application.scan().nextInt();

            while (fileChannel.read(inBuffer) >= 0) {
                inBuffer.flip();

                while (inBuffer.hasRemaining()) {
                    byte value = inBuffer.get();
                    for (int i = 0; i < Alphabet.resAlphabet.length; i++) {
                        if (Alphabet.resAlphabet[i] == (char) value) {
                            System.out.print(Alphabet.resAlphabet[(i + key) % Alphabet.resAlphabet.length]);
                        }
                    }
                }
                inBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


