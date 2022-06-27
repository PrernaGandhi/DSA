package com.dsa.interview.questions.reverse_words;

public class Runner {
    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        String string = "the sky is blue";
        System.out.println(reverseWords.reverseWords(string));
        string = "coding is fun";
        System.out.println(reverseWords.reverseWords(string));
        string = "   hello   world!    ";
        System.out.println(reverseWords.reverseWords(string));
    }
}
