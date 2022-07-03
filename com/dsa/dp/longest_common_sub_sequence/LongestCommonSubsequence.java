package com.dsa.dp.longest_common_sub_sequence;

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
 */
public class LongestCommonSubsequence {

    private int lcs(String str1, int i, String str2, int j) {
        if (i == str1.length() || j == str2.length()) {
            return 0;
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return 1 + lcs(str1, i + 1, str2, j + 1);
        } else {
            return Math.max(lcs(str1, i, str2, j + 1), lcs(str1, i + 1, str2, j));
        }
    }

    public int longestCommonSubsequence(String str1, String str2) {
        return lcs(str1, 0, str2, 0);
    }

    public int longestCommonSubsequenceDP(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
