package com.dsa.dp.knapsack;

public class KnapsackProblem {
    // total number of items
    private int noOfItems;

    // total capacity of Knapsack
    private int capacityOfKnapsack;

    // dynamic programming table (2d array)
    private int [][] dpTable;

    private int [] weights;

    private int [] values;

    public KnapsackProblem(int noOfItems, int capacityOfKnapsack, int [] weights, int [] values) {
        this.noOfItems = noOfItems;
        this.capacityOfKnapsack = capacityOfKnapsack;
        this.weights = weights;
        this.values = values;
        this.dpTable = new int [noOfItems + 1][capacityOfKnapsack + 1];
    }

    public void solve() {

        // time complexity O(noOfItems * capacityOfKnapsack)
        for(int i = 1; i < noOfItems + 1; i++) {
            for(int w = 1; w < capacityOfKnapsack + 1; w++) {
                int notTakingItem = dpTable[i - 1][w];
                int takingItem = 0;

                // check if item can be taken
                if(weights[i] <= w) {
                    takingItem = values[i];
                }
                if(w - weights[i] >= 0) {
                    takingItem += dpTable[i - 1][w - weights[i]];
                }
                // memoization, we store the result
                dpTable[i][w] = Math.max(notTakingItem,takingItem);
            }
        }
    }

    public void showResult() {
        System.out.println("Total benefit : $" + dpTable[noOfItems][capacityOfKnapsack]);
        for(int i = noOfItems, w = capacityOfKnapsack; i > 0; i--) {
            if(dpTable[i][w] !=0 && dpTable[i][w] != dpTable[i-1][w]) {
                System.out.println("We take item #" + i);
                w = w - weights[i];
            }
        }
    }

    public int solveUsingRecursion(int capacityOfKnapsack, int []weights, int []values, int noOfItems) {
        if(capacityOfKnapsack == 0 || noOfItems == 0)
            return 0;

        // the given item can NOT fit into the knapsack
        if(weights[noOfItems - 1] > capacityOfKnapsack) {
            return solveUsingRecursion(capacityOfKnapsack, weights, values, noOfItems--);
        } else {

            // given item can fit into the knapsack so we have 2 options (include, exclude)
            int included = values[noOfItems - 1] + solveUsingRecursion(capacityOfKnapsack - weights[noOfItems - 1], weights, values, noOfItems - 1);
            int excluded = solveUsingRecursion(capacityOfKnapsack, weights, values, noOfItems - 1);
            return Math.max(included, excluded);
        }
    }
}