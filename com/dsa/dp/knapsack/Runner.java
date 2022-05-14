package com.dsa.dp.knapsack;

public class Runner {
    public static void main(String[] args) {
        int noOfItems = 4;
        int capacityOfKnapSack = 7;
        int [] weights = {0,1,3,4,5};
        int [] values = {0,1,4,5,7};
        KnapsackProblem problem = new KnapsackProblem(noOfItems,capacityOfKnapSack,weights,values);
        problem.solve();
        problem.showResult();
        KnapsackProblem recursiveProblem = new KnapsackProblem(noOfItems,capacityOfKnapSack,weights,values);
        System.out.println("Total benefit : $" + recursiveProblem.solveUsingRecursion(capacityOfKnapSack, weights, values, noOfItems));
        weights = new int[]{0, 1, 3, 4, 5};
       values = new int[]{0,1, 4, 5, 7};
        KnapsackProblem recursiveMemoizedProblem = new KnapsackProblem(noOfItems,capacityOfKnapSack,weights,values);
        System.out.println("Total benefit : $" + recursiveMemoizedProblem.solveRecursiveMemoized(noOfItems, capacityOfKnapSack));
        recursiveMemoizedProblem.showResult();
    }
}
