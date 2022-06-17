package com.dsa.interview.questions.length_of_last_word;

public class Runner {
    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord(""));
        System.out.println(lengthOfLastWord.lengthOfLastWord("hello     world"));
        System.out.println(lengthOfLastWord.lengthOfLastWord("     world         "));
    }
}
