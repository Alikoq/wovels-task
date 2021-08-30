package com.interview.service;

import com.interview.entity.Partition;
import com.interview.exception.IncorrectFilePathOrName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class WordAnalyserTest {
    public final static String PATH="src/test/resources/files/sample.txt";
    public final static String EMPTY_FILE="src/test/resources/files/sample-null.txt";
    public final static String WRONG_PATH="src/test/resourdces/files/sample.txt";

    WordAnalyserService wordAnalyserService;
    WriteToFileService writeToFileService;
    @BeforeEach
    public void setUp(){
        writeToFileService=new WriteToFileService();
        wordAnalyserService = new WordAnalyserService();
    }

    @Test
    @DisplayName("This method using for wrong path of file")
    void testWhenFileNotFound(){
         RuntimeException exception=assertThrows(IncorrectFilePathOrName.class,
                 ()->{wordAnalyserService.parseText(WRONG_PATH);});
         assertEquals(exception.getMessage(),"wrong path");

    }

    @Test
    @DisplayName("This method test for empty file")
    void testWhenSentenceNotFound(){
        RuntimeException exception=assertThrows(IncorrectFilePathOrName.class,
                ()->{wordAnalyserService.parseText(EMPTY_FILE);});
        assertEquals(exception.getMessage(),"file is empty");
    }

    @Test
    @DisplayName("When could't write to file")
    void whenCouldNotWriteToFile(){
        Map<String, Partition> map=new HashMap<>();
        map.put("ao4", new Partition(4));
        Exception exception=assertThrows(IOException.class,
                ()->{WriteToFileService.writeToFile(map,WRONG_PATH);});
        assertEquals(exception.getMessage(),"couldn't write to file");
    }
}