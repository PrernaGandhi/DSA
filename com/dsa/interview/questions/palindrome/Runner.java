package com.dsa.interview.questions.palindrome;

public class Runner {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.checkIfPalindrome("madam"));
        System.out.println(palindrome.checkIfPalindrome("madama"));
        System.out.println(palindrome.checkIfPalindrome("maddam"));

    }
}
