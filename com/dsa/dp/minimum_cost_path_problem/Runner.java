package com.dsa.dp.minimum_cost_path_problem;

import java.util.HashMap;

public class Runner {
    public static void main(String[] args) {

        int[][] matrix = {
                {3, 2, 12, 15, 10},
                {6, 19, 7, 11, 17},
                {8, 5, 12, 32, 21},
                {3, 20, 2, 9, 7}
        };

        MinimumCostPathProblem minimumCostPathProblem = new MinimumCostPathProblem(matrix);
        System.out.println("Minimum cost path using recursion\t\t\t\t:\t" + minimumCostPathProblem.calculateUsingRecursion(0, 0));
        minimumCostPathProblem = new MinimumCostPathProblem(matrix);
        System.out.println("Minimum cost path using memoization\t\t\t\t:\t" + minimumCostPathProblem.calculateUsingMemoization(0, 0, new HashMap<>()));
        minimumCostPathProblem = new MinimumCostPathProblem(matrix);
        System.out.println("Minimum cost path using tabulation\t\t\t\t:\t" + minimumCostPathProblem.calculateUsingTabulation());
        minimumCostPathProblem = new MinimumCostPathProblem(matrix);
        System.out.println("Minimum cost path using optimized tabulation\t:\t" + minimumCostPathProblem.calculateOptimizedTabulation());

    }
}
