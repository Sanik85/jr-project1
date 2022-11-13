package com.Sanik85.company.CaesarEnglishEncoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {
    public String readTextFromFile(String filePath) {
        Path path = Paths.get(filePath);
        String fileText = null;
        if (Files.notExists(path)) {
            System.out.println("File is not found!");
        } else {
            try {
                fileText = Files.readString(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileText;
    }
    public void writeTextToFile(String filePath, String fileText) {
        try {
            Path outputPath = Paths.get(filePath);
            Files.writeString(outputPath, fileText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String createNewFilePath (String filePath, String fileStatus){
        StringBuilder sb = new StringBuilder(filePath);
        int index = filePath.lastIndexOf('.');
        sb.insert(index, fileStatus);
        String outputPath = sb.toString();
        return outputPath;
    }
}



