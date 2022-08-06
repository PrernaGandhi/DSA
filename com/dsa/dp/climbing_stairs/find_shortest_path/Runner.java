package com.dsa.dp.climbing_stairs.find_shortest_path;

import java.util.HashMap;

public class Runner {
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();

        System.out.println("shortest path using recursion");
        System.out.println(climbingStairs.shortestPathUsingRecursion(2, 0));
        System.out.println(climbingStairs.shortestPathUsingRecursion(3, 0));
        System.out.println(climbingStairs.shortestPathUsingRecursion(5, 0));

        System.out.println("shortest path using memoization");
        System.out.println(climbingStairs.shortestPathUsingMemoization(2, 0, new HashMap<>()));
        System.out.println(climbingStairs.shortestPathUsingMemoization(3, 0, new HashMap<>()));
        System.out.println(climbingStairs.shortestPathUsingMemoization(5, 0, new HashMap<>()));

        System.out.println("shortest path using tabulation");
        System.out.println(climbingStairs.shortestPathUsingTabulation(2));
        System.out.println(climbingStairs.shortestPathUsingTabulation(3));
        System.out.println(climbingStairs.shortestPathUsingTabulation(5));

        System.out.println("shortest path using optimized tabulation");
        System.out.println(climbingStairs.shortestPathUsingOptimizedTabulation(2));
        System.out.println(climbingStairs.shortestPathUsingOptimizedTabulation(3));
        System.out.println(climbingStairs.shortestPathUsingOptimizedTabulation(5));

    }
}