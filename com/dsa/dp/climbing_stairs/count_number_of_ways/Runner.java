package com.dsa.dp.climbing_stairs.count_number_of_ways;

import java.util.HashMap;

public class Runner {
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println("total number of distinct ways using recursion : ");
        System.out.println(climbingStairs.countNumberOfWaysUsingRecursion(2, 0));
        System.out.println(climbingStairs.countNumberOfWaysUsingRecursion(3, 0));
        System.out.println(climbingStairs.countNumberOfWaysUsingRecursion(5, 0));

        System.out.println("total number of distinct ways using memoization");
        System.out.println(climbingStairs.countNumberOfWaysMemoized(2, 0, new HashMap<>()));
        System.out.println(climbingStairs.countNumberOfWaysMemoized(3, 0, new HashMap<>()));
        System.out.println(climbingStairs.countNumberOfWaysMemoized(5, 0, new HashMap<>()));

        System.out.println("total number of distinct ways using tabulation");
        System.out.println(climbingStairs.countNumberOfWaysTabulation(2));
        System.out.println(climbingStairs.countNumberOfWaysTabulation(3));
        System.out.println(climbingStairs.countNumberOfWaysTabulation(5));

        System.out.println("total number of distinct ways using optimized tabulation");
        System.out.println(climbingStairs.countNumberOfWaysOptimizedTabulation(2));
        System.out.println(climbingStairs.countNumberOfWaysOptimizedTabulation(3));
        System.out.println(climbingStairs.countNumberOfWaysOptimizedTabulation(5));
    }
}