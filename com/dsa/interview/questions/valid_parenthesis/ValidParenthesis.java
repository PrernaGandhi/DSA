package com.dsa.interview.questions.valid_parenthesis;

import java.util.Stack;

/*
            Input       |       Output
     -------------------|---------------------
            ()          |       true
          ()[]{}        |       true
            (]          |       false
           ([)]         |       false
           {[]}         |       true


        Approach 1: Stack
            Time complexity : O(N)
            Space complexity : O(N)

 */
public class ValidParenthesis {

    public boolean isValidParenthesis(String string) {
        Stack<Character> stack = new Stack<>();
        for (Character character : string.toCharArray()) {
            if (character == '(' || character == '{' || character == '[') {
                stack.push(character);
            } else {
                // important condition
                // if we have }] string,
                // we will get runtime
                // error due to stack.pop()
                // when stack is empty
                if (stack.isEmpty()) {
                    return false;
                }
                if (character == ')') {
                    if (stack.peek() == '(') stack.pop();
                    else return false;
                } else if (character == '}') {
                    if (stack.peek() == '{') stack.pop();
                    else return false;
                } else if (character == ']') {
                    if (stack.peek() == '[') stack.pop();
                    else return false;
                }
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }

}
