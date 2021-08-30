package com.interview.service;

import com.interview.entity.Partition;
import com.interview.exception.IncorrectFilePathOrName;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordAnalyserService {
    Map<String, Partition> WORD_PARTITIONS = new HashMap<>();
    private static final String PATH = "src/test/resources/files/output.txt";


    public String replaceSymbols(String str){
        str = str.replaceAll("[^a-zA-Z ]", "");
        return str;
    }
    public void getAverageAndGrouping(String sentence) throws IOException {
        sentence = replaceSymbols(sentence);
        Arrays.stream(sentence.split("\\s"))
                .forEach(word -> {
                    Map<String, Long> letterCountMap = VowelAnalyzerService.generate(word);
                    String key = String.join(",", "("+letterCountMap.keySet()) +", "+word.length()+" )";
                    long sum = letterCountMap.values().stream().mapToLong(l -> l).sum();
                    Partition partitation = null;
                    if (WORD_PARTITIONS.containsKey(key)) {
                        partitation = WORD_PARTITIONS.get(key);
                        partitation.addSum(sum);
                    } else {
                        partitation = new Partition(sum);
                    }

                    partitation.calculateAverage();
                    WORD_PARTITIONS.put(key, partitation);
                });

        WriteToFileService.writeToFile(WORD_PARTITIONS,PATH);
        System.out.println("writed");
    }

    public  void parseText(String path) throws IncorrectFilePathOrName {
        File file=new File(path);
        if(file.length()==0){
            throw new IncorrectFilePathOrName("file is empty");
        }
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(path))) {
            String lineTxt="";
            while  ((lineTxt=bufferedReader.readLine())!=null){
                    getAverageAndGrouping(lineTxt);

            }

        }catch (IOException ex){
            throw new IncorrectFilePathOrName("wrong path");
        }
    }
}
