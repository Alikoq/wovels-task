package com.interview.entity;

public class Partition {

    private long sum;
    private int count;
    private double average;

    public Partition(long sum) {
        this.sum = sum;
    }

    public void addSum(long sum) {
        this.sum += sum;
    }

    public void calculateAverage() {
        count++;
        average = (double) sum / count;
    }

    public double getAverage() {
        return average;
    }
}
