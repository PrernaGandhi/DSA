package com.dsa.dp.longest_increasing_subsequence;

/*
        2 1 3 2 4 3 2 5 4 5
        output : 5

        2   1   3   2   4   3   2   5   4   5
        ^   ^
        |   |
        i   j
        2   1   3   2   4   3   2   5   4   5
        ^       ^
        |       |
        i       j




 */
public class LongestIncreasingSubsequence {

    public int lcs(int[] arr) {
        int result = 1;
        // n - 1
        for (int i = 0; i < arr.length - 1; i++) {
            int lengthOfSubsequenceStartingFromI = 1;
            int currValue = arr[i];
            // n - i - 1
            for (int j = i + 1; j < arr.length; j++) {
                if (currValue + 1 == arr[j]) {
                    currValue = arr[j];
                    lengthOfSubsequenceStartingFromI++;
                }
            }
            result = Math.max(result, lengthOfSubsequenceStartingFromI);
        }
        return result;
    }
}
