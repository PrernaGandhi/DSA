package com.dsa.interview.questions.valid_parenthesis;

public class Runner {
    public static void main(String[] args) {
        String string = "()";
        ValidParenthesis validParenthesis = new ValidParenthesis();
        System.out.println(string + " : " + validParenthesis.isValidParenthesis(string));
        string = "()[]{}";
        System.out.println(string + " : " + validParenthesis.isValidParenthesis(string));
        string = "(]";
        System.out.println(string + " : " + validParenthesis.isValidParenthesis(string));
        string = "([)]";
        System.out.println(string + " : " + validParenthesis.isValidParenthesis(string));
        string = "{[]}";
        System.out.println(string + " : " + validParenthesis.isValidParenthesis(string));
    }
}
