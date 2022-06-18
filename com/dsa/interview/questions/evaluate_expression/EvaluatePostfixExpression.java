package com.dsa.interview.questions.evaluate_expression;

import java.util.Stack;

/*
    Also know as reverse polish notation

    [2  1  +  3  *]

    Rules:
    if we have operand put into stack
    if we have operator pop 2 elements and perform the operation

    Index Of Array      |   Value At Index  |      Stack    |       Operation       |       Result
  ----------------------|-------------------|---------------|-----------------------|-----------------------
            0           |       2           |       [2]     |                       |
            1           |       1           |       [2,1]   |                       |
            2           |       +           |       [3]     |        2 + 1          |           3
            3           |       3           |       [3,3]   |                       |
            4           |       *           |       [9]     |        3 * 3          |           9

            Result is stored at top of stack

    Time Complexity : O(N)
    Space Complexity : O(N)
 */
public class EvaluatePostfixExpression {
    public int evaluatePostfixExpression(String[] postfixExpression) {
        Stack<Integer> stack = new Stack<>();

        for (String ch : postfixExpression) {
            if (isAnOperator(ch)) {
                performOperation(stack, ch);
            } else {
                stack.push(Integer.valueOf(ch));
            }
        }
        return stack.peek();
    }

    private void performOperation(Stack<Integer> stack, String character) {
        int operandOne = stack.pop();
        int operandTwo = stack.pop();
        int result = 0;

        if ("+".equals(character)) {
            result = operandTwo + operandOne;
        } else if ("-".equals(character)) {
            result = operandTwo - operandOne;
        } else if ("*".equals(character)) {
            result = operandTwo * operandOne;
        } else if ("/".equals(character)) {
            result = operandTwo / operandOne;
        }

        stack.push(result);
    }

    private boolean isAnOperator(String character) {
        return "+".equals(character) ||
                "-".equals(character) ||
                "*".equals(character) ||
                "/".equals(character);
    }
}
