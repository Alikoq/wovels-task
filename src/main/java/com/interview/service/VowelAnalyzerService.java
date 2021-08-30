package com.interview.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VowelAnalyzerService {

    private static final List<String> VOWELS = Arrays.asList( "a", "e", "i", "o", "u" );

    public static Map<String, Long> generate(String word) {
        char[] letters = word.toCharArray();
        return IntStream.range(0, letters.length)
                .filter(i -> VOWELS.contains(""+letters[i]))
                .mapToObj(i -> String.valueOf(letters[i]).toLowerCase())
                .collect(Collectors.groupingBy(
                        w -> w,
                        Collectors.counting()
                ));
    }

}
