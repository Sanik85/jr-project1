package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Encoder {
    public final char aUpper = 'A';
    public final char zUpper = 'Z';
    public final char aLower = 'a';
    public final char zLower = 'z';
    public static final int alphabetsCount = 26;
    FilePath fp = new FilePath();

    public void encodeFile(String filePath, int key) {
        String fileText = fp.readTextFromFile(filePath);
        String encodeText = encodeText(fileText, key);
        fp.writeTextToFile(filePath, encodeText, "Encoded");
        System.out.println("Encoding was successfully!");
    }

    public void decodeFile(String filePath, int key) {
        String fileText = fp.readTextFromFile(filePath);
        String encodeText = encodeText(fileText, -key);
        fp.writeTextToFile(filePath, encodeText, "Decoded");
        System.out.println("Decoding was successfully!");
    }

    public String encodeText(String fileText, int key) {
        char[] character = fileText.toCharArray();
        char[] encodeCharacter = new char[character.length];
        for (int i = 0; i < character.length; i++) {
            encodeCharacter[i] = encodeCharacter(character[i], key);
        }
        String encodeText = new String(encodeCharacter);
        return encodeText;
    }


    public char encodeCharacter(char character, int key) {
        int keyEncode = key % alphabetsCount;
        char encodSymbol;
        if (isUpperCase(character)) {
            encodSymbol = aChar(character, keyEncode, zUpper, aUpper);
        } else if (isLowerCase(character)) {
            encodSymbol = aChar(character, keyEncode, zLower, aLower);
        } else encodSymbol = character;
        return encodSymbol;
    }

    public char aChar(int c, int key, int z, int a) {
        char character = (char) (c + key);
        if ((c + key) > z) {
            character = (char) (c + key - alphabetsCount);
        } else if ((c + key) < a) {
            character = (char) (c + key + alphabetsCount);
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
        if (character >= aUpper && character <= zUpper) {
            return true;
        } else return false;
    }

    public boolean isLowerCase(char character) {
        if (character >= aLower && character <= zLower) {
            return true;
        } else return false;
    }
}
