package com.dsa.dp.house_robber_problem;

import java.util.Map;

/*
    We need to rob the house such that we can't rob two adjacent houses
    [2, 10, 3, 6, 8, 1, 7]  ==> 25
 */
public class HouseRobberProblem {
    int[] array;

    public HouseRobberProblem(int[] array) {
        this.array = array;
    }

    int robUsingRecursion(int i) {
        if (i >= array.length) {
            return 0;
        }
        return Math.max(array[i] + robUsingRecursion(i + 2), robUsingRecursion(i + 1));
    }

    int robUsingMemoization(int i, Map<Integer, Integer> lookupTable) {
        if (lookupTable.containsKey(i)) {
            return lookupTable.get(i);
        }
        if (i >= array.length) {
            lookupTable.put(i, 0);
            return 0;
        }
        int value = Math.max(array[i] + robUsingMemoization(i + 2, lookupTable), robUsingMemoization(i + 1, lookupTable));
        lookupTable.put(i, value);
        return value;
    }

    int robUsingTabulation() {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            dp[i] = Math.max(array[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[array.length - 1];
    }

    int robUsingOptimizedTabulation() {
        int prev = array[0];
        int curr = array[1];
        int next = 0;
        for (int i = 2; i < array.length; i++) {
            next = Math.max(array[i] + prev, curr);
            prev = curr;
            curr = next;
        }
        return next;
    }
}
