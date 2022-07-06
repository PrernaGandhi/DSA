package com.dsa.dp.longest_palindromic_string;

public class Runner {
    public static void main(String[] args) {
        LongestPalindromicString longestPalindromicString = new LongestPalindromicString();
        System.out.println(longestPalindromicString.find("a"));
        System.out.println("DP : " + longestPalindromicString.findDP("a"));
        System.out.println(longestPalindromicString.find("aba"));//6
        System.out.println("DP : " + longestPalindromicString.findDP("aba"));//
        System.out.println(longestPalindromicString.find("abs"));//6
        System.out.println("DP : " + longestPalindromicString.findDP("abs"));//
        System.out.println(longestPalindromicString.find("ababad"));//62
        System.out.println("DP : " + longestPalindromicString.findDP("ababad"));//24
        System.out.println(longestPalindromicString.find("babad"));//31
        System.out.println("DP : " + longestPalindromicString.findDP("babad"));//16
        System.out.println(longestPalindromicString.find("baab"));//14
        System.out.println("DP : " + longestPalindromicString.findDP("baab"));//9
    }
}
