package com.dsa.interview.questions.trapping_rain_water_problem;

public class TrappingRainWaterProblem {
    /*
    Given n non-negative integers representing an elevation map
    where the width of each bar is 1. Compute how much water it can trap after raining!

                 __
     __         |  |
    |  |   __   |  |
    |  |  |  |  |  |
    |  |__|  |__|  |
    |__ __ __ __ __|
    Here the elevation map (the input for the algorithm) is [4,1,3,1,5] and
    the output is the total units of trapped rain water - which is 7.
     */

    public int solve(int[] arr) {
        int boundary = Math.min(arr[0], arr[arr.length - 1]);
        int sum = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < boundary)
                sum += (boundary - arr[i]);
            else
                boundary = arr[i];
        }
        return sum;
    }
}
