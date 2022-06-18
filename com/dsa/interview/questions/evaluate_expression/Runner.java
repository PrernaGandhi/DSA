package com.dsa.interview.questions.evaluate_expression;

public class Runner {
    public static void main(String[] args) {
        EvaluatePostfixExpression expression = new EvaluatePostfixExpression();
        System.out.println(expression.evaluatePostfixExpression(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(expression.evaluatePostfixExpression(new String[]{"4", "13", "5", "/", "+"}));
    }
}
