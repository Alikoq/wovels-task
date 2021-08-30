package com.interview.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Vowels {
    String word;
    List<Character> charsVowels=new ArrayList<>();
    Integer count;

    public static Vowels of(String word,List<Character> chars,int count){
         Vowels vowels=new Vowels();
         vowels.word=word;
         vowels.charsVowels.addAll(chars);
         vowels.count=count;
         return vowels;
    }
    public List<Character> getCharsVowels() {
        return charsVowels;
    }

    public void setCharsVowels(List<Character> charsVowels) {
        this.charsVowels = charsVowels;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Vowels{" +
                "word='" + word + '\'' +
                ", charsVowels=" + charsVowels +
                ", count=" + count +
                '}';
    }
}
