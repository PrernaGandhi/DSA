package com.dsa.interview.questions.remove_two_adjacent_duplicates;

import java.util.Objects;
import java.util.Stack;

/*
       Remove two adjacent duplicates
        Input               |           Output
      ----------------------|-----------------------
        "aab"               |           "b"
        "aa"                |           ""
        "baab"              |           ""
        "aaa"               |           "a"
        "aaabccddd"         |           "abd"
        "mississippi"       |           "m"


 */
public class RemoveTwoAdjacentDuplicates {

    public String removeAdjacentDuplicates(String string) {
        Stack<Character> stack = new Stack<>();
        for (Character character : string.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(character);
            } else if (Objects.equals(stack.peek(), character)) {
                stack.pop();
            } else {
                stack.push(character);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }
}
