package com.interview;

import com.interview.service.WordAnalyserService;

import java.io.FileNotFoundException;

public class AppRunner {
    public final static String PATH="src/test/resources/files/sample.txt";
    public static void main(String[] args) throws FileNotFoundException {
        WordAnalyserService wordAnalyserService =new WordAnalyserService();
        wordAnalyserService.parseText(PATH);
    }
}
