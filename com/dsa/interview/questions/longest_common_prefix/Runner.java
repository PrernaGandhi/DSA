package com.dsa.interview.questions.longest_common_prefix;

public class Runner {
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.
                getLongestCommonPrefix(new String[]{"abcdef",
                        "aefghij",
                        "abcefg"}));
        System.out.println(longestCommonPrefix.
                getLongestCommonPrefix(new String[]{"flower",
                        "flow",
                        "flight"}));
        System.out.println(longestCommonPrefix.
                getLongestCommonPrefix(new String[]{"dogcar",
                        "racecar",
                        "car"}));
        System.out.println(longestCommonPrefix.
                getLongestCommonPrefix(new String[]{}));
        System.out.println(longestCommonPrefix.
                getLongestCommonPrefix(new String[]{"geeksforgeeks",
                        "geeks",
                        "geeks",
                        "geezer"}));
    }
}
