package com.dsa.dp.target_sum;


public class Runner {
    public static void main(String[] args) {
        TargetSum problem = new TargetSum();
        int[] arr = {1, 1, 1, 1, 1};
        int targetSum = 3;
        System.out.println(problem.findPaths(arr, targetSum));
        System.out.println(problem.findPathsDP(arr, targetSum));
    }
}
