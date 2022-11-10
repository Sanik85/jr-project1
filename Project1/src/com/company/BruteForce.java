package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BruteForce {
    Encoder encoder = new Encoder();
    FilePath fp = new FilePath();
    public void keyOfEncodeFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            String fileText = Files.readString(path);
            char[] chars = fileText.toCharArray();

            for (int i = 1; i < Encoder.alphabetsCount; i++) {
                StringBuilder sb = new StringBuilder();
                for (char aChar : chars) {
                    sb.append(encoder.encodeCharacter(aChar, -i));
                }
                if (sb.toString().toLowerCase().contains(" is ")) {
                    System.out.println("key = " + i);
                    fp.writeTextToFile(filePath, sb.toString(),  "(decoded key = " + i + ")");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
