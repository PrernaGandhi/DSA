package com.dsa.interview.questions.largest_sum_subarray;

public class LargestSumSubArray {
    // 1 -2 3 4 -5 8

    /*
        current sum = 1
        max sum = 1

        current sum = -1
        max sum = 1

        current sum = 3
        max sum = 3

        current sum = max(4, 7)
        max sum = max(7, 3)

        current sum = max(- 5, 7 -5)
        max sum = 7

        current sum = max(8, 2+8)
        max sum = 9
     */
    public int solve(int[] array) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int element : array) {
            // we are maximizing the current sum in each step,
            // we are checking if previous sum + the current value (including in the subset)
            // and current value (starting afresh from this value)
            // whichever is greater
            currentSum = Math.max(element, currentSum + element);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
