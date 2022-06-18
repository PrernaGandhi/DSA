package com.dsa.interview.questions.reverse_string;

import java.util.Stack;

public class ReverseString {

    // O(N/2) if size of input is N
    public String reverseString(String string) {

        int startPointer = 0;
        int endPointer = string.length() - 1;

        char[] chars = string.toCharArray();
        while (startPointer <= endPointer) {
            swap(chars, startPointer, endPointer);
            startPointer++;
            endPointer--;
        }
        return String.valueOf(chars);
    }

    private void swap(char[] chars, int startPointer, int endPointer) {
        char temp = chars[startPointer];
        chars[startPointer] = chars[endPointer];
        chars[endPointer] = temp;
    }

    public String reverseStringUsingStack(String string) {
        Stack<Character> stack = new Stack<>();
        // O(N) if N is length of string
        for (Character ch : string.toCharArray()) {
            stack.push(ch);
        }

        // O(N) is N is length of string
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            stringBuilder.append(stack.pop());
        }
        string = stringBuilder.toString();
        return string;
    }
}
