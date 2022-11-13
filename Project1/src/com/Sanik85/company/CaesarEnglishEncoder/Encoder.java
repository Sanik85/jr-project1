package com.Sanik85.company.CaesarEnglishEncoder;

public class Encoder {
    public static final char AUPPER = 'A';
    public static final char ZUPPER = 'Z';
    public static final char ALOWER = 'a';
    public static final char ZLOWER = 'z';
    public static final int ALPHABETSIZE = 26;
    FileService fileService = new FileService();

    public void encodeFile(String filePath, int key) {
        String fileText = fileService.readTextFromFile(filePath);
        String encodedText = encodeText(fileText, key);
        String newFilePath = fileService.createNewFilePath(filePath, "(Encoded)");
        fileService.writeTextToFile(newFilePath, encodedText);
        System.out.println("Encoding was successfull!");
    }

    public void decodeFile(String filePath, int key) {
        String fileText = fileService.readTextFromFile(filePath);
        String encodeText = encodeText(fileText, -key);
        String newFilePath = fileService.createNewFilePath(filePath, "(Decoded)");
        fileService.writeTextToFile(newFilePath, encodeText);
        System.out.println("Decoding was successfull!");
    }

    public String encodeText(String text, int key) {
        char[] characters = text.toCharArray();
        char[] encodeCharacters = new char[characters.length];
        for (int i = 0; i < characters.length; i++) {
            encodeCharacters[i] = encodeCharacter(characters[i], key);
        }
        return new String(encodeCharacters);
    }


    public char encodeCharacter(char character, int key) {
        int keyEncode = key % ALPHABETSIZE;
        char encodedSymbol;
        if (isUpperCase(character)) {
            encodedSymbol = encodeCharacter(character, keyEncode,AUPPER, ZUPPER);
        } else if (isLowerCase(character)) {
            encodedSymbol = encodeCharacter(character, keyEncode, ALOWER, ZLOWER);
        } else encodedSymbol = character;
        return encodedSymbol;
    }

    private char encodeCharacter(int c, int key, int a, int z) {
        char character = (char) (c + key);
        if ((c + key) > z) {
            character = (char) (c + key - ALPHABETSIZE);
        } else if ((c + key) < a) {
            character = (char) (c + key + ALPHABETSIZE);
        }
        return character;
    }

    private boolean isUpperCase(char character) {
        if (character >= AUPPER && character <= ZUPPER) {
            return true;
        } else return false;
    }

    private boolean isLowerCase(char character) {
        if (character >= ALOWER && character <= ZLOWER) {
            return true;
        } else return false;
    }
}
