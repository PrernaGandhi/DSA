package com.dsa.dp.longest_increasing_subsequence;

public class Runner {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 2, 4, 3, 2, 5, 4, 5};
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.lcs(arr));
        arr = new int[]{2, 3, 2, 4, 3, 2, 5, 4, 5, 1};
        System.out.println(longestIncreasingSubsequence.lcs(arr));
    }
}
