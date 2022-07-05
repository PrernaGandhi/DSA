package com.dsa.dp.climbing_stairs;

import java.util.HashMap;
import java.util.Map;

/*
        n = 2,
        we have two choices, whether we take a step of 1, or 2

        0 -> 1 -> 1
        0 -> 1 -> 2     X
        0 -> 2
        0 -> 2 -> 2     X

 */
public class ClimbingStairs {
    private int countNumberOfWays(int n, int currentStep) {
        if (currentStep > n) {
            return 0;
        }
        if (currentStep == n) {
            return 1;
        }

        int choice1 = countNumberOfWays(n, currentStep + 1);
        int choice2 = countNumberOfWays(n, currentStep + 2);
        return choice1 + choice2;
    }

    public int countNumberOfDistinctWays(int n) {
        return countNumberOfWays(n, 0);
    }

    private int countNumberOfWaysDP(int n, int currentStep, Map<Integer, Integer> map) {
        if (currentStep > n) {
            return 0;
        }
        if (currentStep == n) {
            return 1;
        }
        if (map.containsKey(currentStep)) {
            return map.get(currentStep);
        }
        int choice1 = countNumberOfWaysDP(n, currentStep + 1, map);
        int choice2 = countNumberOfWaysDP(n, currentStep + 2, map);
        int noOfWays = choice1 + choice2;
        map.put(currentStep, noOfWays);
        return noOfWays;
    }

    public int countNumberOfDistinctWaysDP(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return countNumberOfWaysDP(n, 0, map);
    }

    private int countLongestPath(int n, int currentStep) {
        if (currentStep >= n) {
            return 0;
        }
        int choice1 = 1 + countLongestPath(n, currentStep + 1);
        int choice2 = 1 + countLongestPath(n, currentStep + 2);
        return Math.max(choice1, choice2);
    }

    public int countLongestPath(int n) {
        return countLongestPath(n, 0);
    }

    private int countLongestPathDP(int n, int currentStep, Map<Integer, Integer> map) {
        if (currentStep >= n) {
            return 0;
        }
        if (map.containsKey(currentStep)) {
            return map.get(currentStep);
        }
        int choice1 = 1 + countLongestPathDP(n, currentStep + 1, map);
        int choice2 = 1 + countLongestPathDP(n, currentStep + 2, map);
        int max = Math.max(choice1, choice2);
        map.put(currentStep, max);
        return max;
    }

    public int countLongestPathDP(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return countLongestPathDP(n, 0, map);
    }

    private int countShortestPath(int n, int currentStep) {
        if (currentStep >= n) {
            return 0;
        }
        int choice1 = 1 + countShortestPath(n, currentStep + 1);
        int choice2 = 1 + countShortestPath(n, currentStep + 2);
        return Math.min(choice1, choice2);
    }

    public int countShortestPath(int n) {
        return countShortestPath(n, 0);
    }

    private int countShortestPathDP(int n, int currentStep, Map<Integer, Integer> map) {
        if (currentStep >= n) {
            return 0;
        }
        if (map.containsKey(currentStep)) {
            return map.get(currentStep);
        }
        int choice1 = 1 + countShortestPathDP(n, currentStep + 1, map);
        int choice2 = 1 + countShortestPathDP(n, currentStep + 2, map);
        int min = Math.min(choice1, choice2);
        map.put(currentStep, min);
        return min;
    }

    public int countShortestPathDP(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return countShortestPathDP(n, 0, map);
    }


}
