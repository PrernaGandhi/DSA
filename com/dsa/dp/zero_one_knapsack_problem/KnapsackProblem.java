package com.dsa.dp.zero_one_knapsack_problem;

import java.util.HashMap;
import java.util.Map;

public class KnapsackProblem {
    private int calculate(int[] prices, int[] weight, int weightOfKnapsack, int currentIndex) {
        if (currentIndex == weight.length) {
            return 0;
        }
        if (weight[currentIndex] <= weightOfKnapsack) {
            return Math.max(calculate(prices, weight, weightOfKnapsack, currentIndex + 1),
                    prices[currentIndex] + calculate(prices, weight,
                            weightOfKnapsack - weight[currentIndex], currentIndex + 1));
        } else {
            return calculate(prices, weight, weightOfKnapsack, currentIndex + 1);
        }
    }

    public int calculate(int[] prices, int[] weight, int weightOfKnapsack) {
        return calculate(prices, weight, weightOfKnapsack, 0);
    }

    private int calculateDP(int[] prices, int[] weight, int weightOfKnapsack, int currentIndex, Map<Integer, Integer> map) {
        if (currentIndex == weight.length) {
            return 0;
        }
        if (map.containsKey(weightOfKnapsack)) {
            return map.get(weightOfKnapsack);
        }
        if (weight[currentIndex] <= weightOfKnapsack) {
            int max = Math.max(calculateDP(prices, weight, weightOfKnapsack, currentIndex + 1, map),
                    prices[currentIndex] + calculateDP(prices, weight,
                            weightOfKnapsack - weight[currentIndex], currentIndex + 1, map));
            map.put(weightOfKnapsack, max);
            return max;
        } else {
            int max = calculateDP(prices, weight, weightOfKnapsack, currentIndex + 1, map);
            map.put(weightOfKnapsack, max);
            return max;
        }
    }

    public int calculateDP(int[] prices, int[] weight, int weightOfKnapsack) {
        Map<Integer, Integer> map = new HashMap<>();
        return calculateDP(prices, weight, weightOfKnapsack, 0, map);
    }
}
