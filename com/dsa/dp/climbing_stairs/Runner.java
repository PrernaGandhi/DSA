package com.dsa.dp.climbing_stairs;

public class Runner {
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println("count total number of distinct ways");
        System.out.println(climbingStairs.countNumberOfDistinctWays(2));
        System.out.println(climbingStairs.countNumberOfDistinctWays(3));
        System.out.println(climbingStairs.countNumberOfDistinctWays(5));

        System.out.println("DP : count total number of distinct ways");
        System.out.println(climbingStairs.countNumberOfDistinctWaysDP(2));
        System.out.println(climbingStairs.countNumberOfDistinctWaysDP(3));
        System.out.println(climbingStairs.countNumberOfDistinctWaysDP(5));

        System.out.println("longest path");
        System.out.println(climbingStairs.countLongestPath(2));
        System.out.println(climbingStairs.countLongestPath(3));
        System.out.println(climbingStairs.countLongestPath(5));

        System.out.println("DP : longest path");
        System.out.println(climbingStairs.countLongestPathDP(2));
        System.out.println(climbingStairs.countLongestPathDP(3));
        System.out.println(climbingStairs.countLongestPathDP(5));

        System.out.println("shortest path");
        System.out.println(climbingStairs.countShortestPath(2));
        System.out.println(climbingStairs.countShortestPath(3));
        System.out.println(climbingStairs.countShortestPath(5));

        System.out.println("DP : shortest path");
        System.out.println(climbingStairs.countShortestPathDP(2));
        System.out.println(climbingStairs.countShortestPathDP(3));
        System.out.println(climbingStairs.countShortestPathDP(5));
    }
}
