package com.company;

public class Main {
    public static void main(String[] args) {

        String comand = args[0];
        System.out.println(comand);
        Encoder encoder = new Encoder();
        if ("encode".equals(comand)) {
            String filePath = args[1];
            int key = Integer.parseInt(args[2]);
            encoder.encodeFile(filePath, key);
        } else if ("decode".equals(comand)) {
            String filePath = args[1];
            int key = Integer.parseInt(args[2]);
            encoder.decodeFile(filePath, key);
        } else if ("bruteForce".equals(comand)) {
            String filePath = args[1];
            BruteForce bruteForce = new BruteForce();
            bruteForce.keyOfEncodeFile(filePath);
        }
    }
}