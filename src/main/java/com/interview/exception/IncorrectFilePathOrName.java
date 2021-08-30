package com.interview.exception;

public class IncorrectFilePathOrName extends RuntimeException{
    public IncorrectFilePathOrName(String msg){
        super(msg);
    }
}
