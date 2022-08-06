package com.dsa.dp.longest_common_sub_sequence;

import java.util.Map;

/*
        Example:
            Input 1: "apple"
            Input 2: "mango"

            Output : "a"

            Input 1: "apple"
            Input 2: "ample"

            Output : "aple"

            Input 1: "apple"
            Input 2: "maengo"

            Output: "ae"

            Recurrence relation :

                        0                               i=length of s1, or j=length of s2
            lcs(i,j) =  1 + lcs(i+1,j+1)                when s[i]=s[j]
                        max(lcs(i+1,j),lcs(i,j+1))      otherwise


 */
public class LongestCommonSubsequence {

    public int lcsUsingRecursion(String str1, int i, String str2, int j) {
        if (i == str1.length() || j == str2.length()) {
            return 0;
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return 1 + lcsUsingRecursion(str1, i + 1, str2, j + 1);
        } else {
            return Math.max(lcsUsingRecursion(str1, i, str2, j + 1), lcsUsingRecursion(str1, i + 1, str2, j));
        }
    }

    public int lcsUsingRecursionUsingMemoization(String str1, int i, String str2, int j, Map<String, Integer> lookupTable) {
        String key = i + ", " + j;
        if (lookupTable.containsKey(key)) {
            return lookupTable.get(key);
        }
        if (i == str1.length() || j == str2.length()) {
            return 0;
        }

        int value;
        if (str1.charAt(i) == str2.charAt(j)) {
            value = 1 + lcsUsingRecursionUsingMemoization(str1, i + 1, str2, j + 1, lookupTable);
        } else {
            value = Math.max(lcsUsingRecursionUsingMemoization(str1, i, str2, j + 1, lookupTable),
                    lcsUsingRecursionUsingMemoization(str1, i + 1, str2, j, lookupTable));
        }
        lookupTable.put(key, value);
        return value;
    }

    public int lcsUsingTabulation(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }

    public int lcsUsingOptimizedTabulation(String str1, String str2) {
        int[] dp = new int[str2.length() + 1];
        int[] prevDp = new int[str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[j] = 1 + prevDp[j - 1];
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prevDp = dp;
            }
        }
        return dp[str2.length()];
    }
}
