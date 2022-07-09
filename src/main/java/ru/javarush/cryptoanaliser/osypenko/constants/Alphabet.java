package ru.javarush.cryptoanaliser.osypenko.constants;

public class Alphabet {
    private static final String RU = "йцукенгшщзхъфывапролджэячсмитьбю";
    private static final String EN = "qwertyuiopasdfghjklzxcvbnm";
    private static final String CH = ".,:;'-+=*{}[]()/\\\" ";
    private static final String NUM = "0123456789";
    private static final byte BYTENUMBERJUMP = 10;
    private static final char JUMP = (char) BYTENUMBERJUMP;
    private static final String ALPHABET = EN + EN.toUpperCase() + JUMP + CH + NUM + JUMP + RU + RU.toUpperCase() + JUMP;
    public static char[] resAlphabet = ALPHABET.toCharArray();

}