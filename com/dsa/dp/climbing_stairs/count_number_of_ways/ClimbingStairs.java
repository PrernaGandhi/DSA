package com.dsa.dp.climbing_stairs.count_number_of_ways;

import java.util.Map;

/*
    Count number of ways to climb stairs,
    possible moves - 1 step, 2 step

        n = 2,
        we have two choices, whether we take a step of 1, or 2

        0 -> 1 -> 1
        0 -> 1 -> 2     X
        0 -> 2
        0 -> 2 -> 2     X

        n = 5
                       __
                    __|  |
                 __|  |  |
              __|  |  |  |
           __|  |  |  |  |
        0 |  |  |  |  |  |
            1  2  3  4  5

    base case to reach 5 from 5, we have only 1 way
    base case to reach 5 from 4, we have only 1 way

    now to reach 5 from 3, we can either go to 4 by taking 1 step, or to 5 by taking 2 steps
    but we already know the values for 4 and 5, 1 way[(3 to 4) to (4 to 5)], and 1 way [(3 to 5) to 1(5 to 5)]
    so from 3, we can use values of 4 and 5 = 1 + 1 = 2,

    now for 2, we can either reach 3 by taking 1 step, or 4 by taking 2 steps
    now to calculate no of ways to reach 5 from 2 would be, value of 3 + value of 4 = 2 + 1 = 3

    Recurrence Relation :

            0                     i>n
            1                     i=n
    steps(i+1) + steps(i+2)     otherwise

 */
public class ClimbingStairs {
    public int countNumberOfWaysUsingRecursion(int n, int currentStep) {
        if (currentStep > n) {
            return 0;
        }
        if (currentStep == n) {
            return 1;
        }

        int choice1 = countNumberOfWaysUsingRecursion(n, currentStep + 1);
        int choice2 = countNumberOfWaysUsingRecursion(n, currentStep + 2);
        return choice1 + choice2;
    }

    public int countNumberOfWaysMemoized(int n, int currentStep, Map<Integer, Integer> map) {
        if (currentStep > n) {
            return 0;
        }
        if (currentStep == n) {
            return 1;
        }
        if (map.containsKey(currentStep)) {
            return map.get(currentStep);
        }
        int choice1 = countNumberOfWaysMemoized(n, currentStep + 1, map);
        int choice2 = countNumberOfWaysMemoized(n, currentStep + 2, map);
        int noOfWays = choice1 + choice2;
        map.put(currentStep, noOfWays);
        return noOfWays;
    }

    public int countNumberOfWaysTabulation(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public int countNumberOfWaysOptimizedTabulation(int n) {
        int prev = 1;
        int curr = 2;
        int next = curr;
        for (int i = 2; i < n; i++) {
            next = prev + curr;
            prev = curr;
            curr = next;
        }
        return next;
    }
}