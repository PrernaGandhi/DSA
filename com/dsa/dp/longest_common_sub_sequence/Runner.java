package com.dsa.dp.longest_common_sub_sequence;

public class Runner {
    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.longestCommonSubsequence("apple","mango"));
        System.out.println(lcs.longestCommonSubsequence("apple","maengo"));
        System.out.println(lcs.longestCommonSubsequence("apple","ample"));
        System.out.println(lcs.longestCommonSubsequenceDP("apple","mango"));
        System.out.println(lcs.longestCommonSubsequenceDP("apple","maengo"));
        System.out.println(lcs.longestCommonSubsequenceDP("apple","ample"));
    }
}
