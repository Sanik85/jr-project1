package com.Sanik85.company.CaesarEncoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BruteForce {
    Encoder encoder = new Encoder();
    FileService fileService = new FileService();
    public void getKeyOfEncodeFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            String fileText = Files.readString(path);
            char[] chars = fileText.toCharArray();

            for (int i = 1; i < Encoder.ALPHABETSIZE; i++) {
                StringBuilder sb = new StringBuilder();
                for (char aChar : chars) {
                    sb.append(encoder.encodeCharacter(aChar, -i));
                }
                if (sb.toString().toLowerCase().contains(" is ")) {
                    System.out.println("key = " + i);
                    String newFilePath = fileService.createNewFilePath(filePath, "(decoded key = " + i + ")");
                    fileService.writeTextToFile(newFilePath, sb.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
