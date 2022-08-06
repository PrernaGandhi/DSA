package com.dsa.dp.climbing_stairs.find_longest_path;

import java.util.HashMap;

public class Runner {
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();

        System.out.println("longest path using recursion");
        System.out.println(climbingStairs.longestPathUsingRecursion(2, 0));
        System.out.println(climbingStairs.longestPathUsingRecursion(3, 0));
        System.out.println(climbingStairs.longestPathUsingRecursion(5, 0));

        System.out.println("longest path using memoization");
        System.out.println(climbingStairs.longestPathUsingMemoization(2, 0, new HashMap<>()));
        System.out.println(climbingStairs.longestPathUsingMemoization(3, 0, new HashMap<>()));
        System.out.println(climbingStairs.longestPathUsingMemoization(5, 0, new HashMap<>()));

        System.out.println("longest path using tabulation");
        System.out.println(climbingStairs.longestPathUsingTabulation(2));
        System.out.println(climbingStairs.longestPathUsingTabulation(3));
        System.out.println(climbingStairs.longestPathUsingTabulation(5));

        System.out.println("longest path using optimized tabulation");
        System.out.println(climbingStairs.longestPathUsingOptimizedTabulation(2));
        System.out.println(climbingStairs.longestPathUsingOptimizedTabulation(3));
        System.out.println(climbingStairs.longestPathUsingOptimizedTabulation(5));

    }
}
