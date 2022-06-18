package com.dsa.interview.questions.reverse_string;

public class Runner {
    public static void main(String[] args) {

        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseString("Maam"));
        System.out.println(reverseString.reverseString("Mam"));
        System.out.println(reverseString.reverseString(""));
        System.out.println(reverseString.reverseString("hello"));
        System.out.println(reverseString.reverseString("a"));
        System.out.println(reverseString.reverseString("Madam"));

        System.out.println("----------------Using stack-----------------");

        System.out.println(reverseString.reverseStringUsingStack("Maam"));
        System.out.println(reverseString.reverseStringUsingStack("Mam"));
        System.out.println(reverseString.reverseStringUsingStack(""));
        System.out.println(reverseString.reverseStringUsingStack("hello"));
        System.out.println(reverseString.reverseStringUsingStack("a"));
        System.out.println(reverseString.reverseStringUsingStack("Madam"));
    }
}
