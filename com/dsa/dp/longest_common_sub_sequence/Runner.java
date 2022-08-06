package com.dsa.dp.longest_common_sub_sequence;

import java.util.HashMap;

public class Runner {
    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println("lcs using recursion : ");
        System.out.println(lcs.lcsUsingRecursion("apple", 0, "mango", 0));
        System.out.println(lcs.lcsUsingRecursion("apple", 0, "maengo", 0));
        System.out.println(lcs.lcsUsingRecursion("apple", 0, "ample", 0));
        System.out.println("lcs using memoization : ");
        System.out.println(lcs.lcsUsingRecursionUsingMemoization("apple", 0, "mango", 0, new HashMap<>()));
        System.out.println(lcs.lcsUsingRecursionUsingMemoization("apple", 0, "maengo", 0, new HashMap<>()));
        System.out.println(lcs.lcsUsingRecursionUsingMemoization("apple", 0, "ample", 0, new HashMap<>()));
        System.out.println("lcs using tabulation : ");
        System.out.println(lcs.lcsUsingTabulation("apple", "mango"));
        System.out.println(lcs.lcsUsingTabulation("apple", "maengo"));
        System.out.println(lcs.lcsUsingTabulation("apple", "ample"));
        System.out.println("lcs using optimized tabulation : ");
        System.out.println(lcs.lcsUsingOptimizedTabulation("apple", "mango"));
        System.out.println(lcs.lcsUsingOptimizedTabulation("apple", "maengo"));
        System.out.println(lcs.lcsUsingOptimizedTabulation("apple", "ample"));
    }
}
