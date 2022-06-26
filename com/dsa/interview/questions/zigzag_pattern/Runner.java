package com.dsa.interview.questions.zigzag_pattern;

public class Runner {
    public static void main(String[] args) {
        ZigZagPattern zigZagPattern = new ZigZagPattern();
        System.out.println(zigZagPattern.convert("PAYPALISHIRING", 4));
        System.out.println(zigZagPattern.convert("PAYPALISHIRING", 3));

    }
}
