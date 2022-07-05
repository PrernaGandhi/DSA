package com.dsa.dp.zero_one_knapsack_problem;

public class Runner {
    public static void main(String[] args) {
        int[] weight = {10, 20, 30};
        int[] prices = {60, 100, 120};
        int weightOfKnapsack = 50;
        KnapsackProblem knapsackProblem = new KnapsackProblem();
        System.out.println(knapsackProblem.calculate(prices, weight, weightOfKnapsack));
        System.out.println(knapsackProblem.calculateDP(prices, weight, weightOfKnapsack));
        weight = new int[]{12, 13, 15, 19};
        prices = new int[]{10, 20, 30, 40};
        weightOfKnapsack = 10;
        System.out.println(knapsackProblem.calculate(prices, weight, weightOfKnapsack));
        System.out.println(knapsackProblem.calculateDP(prices, weight, weightOfKnapsack));
    }
}
