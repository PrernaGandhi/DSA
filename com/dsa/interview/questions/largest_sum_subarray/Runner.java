package com.dsa.interview.questions.largest_sum_subarray;

public class Runner {
    public static void main(String[] args) {
        int [] arr = {1, -2, 3, 4, -5, 8};
        LargestSumSubArray problem = new LargestSumSubArray();
        System.out.println(problem.solve(arr));
    }
}
