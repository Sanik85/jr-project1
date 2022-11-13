package com.Sanik85.company.CaesarEncoder;

import java.nio.file.Path;

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
        char[] character = text.toCharArray();
        char[] encodeCharacter = new char[character.length];
        for (int i = 0; i < character.length; i++) {
            encodeCharacter[i] = encodeCharacter(character[i], key);
        }
        String encodeText = new String(encodeCharacter);
        return encodeText;
    }


    public char encodeCharacter(char character, int key) {
        int keyEncode = key % ALPHABETSIZE;
        char encodSymbol;
        if (isUpperCase(character)) {
            encodSymbol = aChar(character, keyEncode, ZUPPER, AUPPER);
        } else if (isLowerCase(character)) {
            encodSymbol = aChar(character, keyEncode, ZLOWER, ALOWER);
        } else encodSymbol = character;
        return encodSymbol;
    }

    public char aChar(int c, int key, int z, int a) {
        char character = (char) (c + key);
        if ((c + key) > z) {
            character = (char) (c + key - ALPHABETSIZE);
        } else if ((c + key) < a) {
            character = (char) (c + key + ALPHABETSIZE);
        }
        return character;
    }

//    public char encodeCharacter2(char character, int key) {
//        int keyEncode = key % alphabetsCount;
//        char encodSymbol = (char) (character + keyEncode);
//        if (isUpperCase(character)) {
//            if ((character + keyEncode) > zUpper) {
//                encodSymbol = (char) (character + keyEncode - alphabetsCount);
//            } else if ((character + keyEncode) < aUpper) {
//                encodSymbol = (char) (character + keyEncode + alphabetsCount);
//            }
//        } else if (isLowerCase(character)) {
//            if ((character + keyEncode) > zLower) {
//                encodSymbol = (char) (character + keyEncode - alphabetsCount);
//            } else if ((character + keyEncode) < aLower) {
//                encodSymbol = (char) (character + keyEncode + alphabetsCount);
//            }
//        } else encodSymbol = character;
//        return encodSymbol;
//    }


    public boolean isUpperCase(char character) {
        if (character >= AUPPER && character <= ZUPPER) {
            return true;
        } else return false;
    }

    public boolean isLowerCase(char character) {
        if (character >= ALOWER && character <= ZLOWER) {
            return true;
        } else return false;
    }
}
