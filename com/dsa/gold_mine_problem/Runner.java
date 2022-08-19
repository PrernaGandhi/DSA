package com.dsa.gold_mine_problem;

public class Runner {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 2, 12, 15, 10},
                {6, 19, 7, 11, 17},
                {8, 5, 12, 32, 21},
                {3, 20, 2, 9, 7}
        };

        GoldMineProblem goldMineProblem = new GoldMineProblem(matrix);
        System.out.println("calculating max gold using recursion \t\t\t: " + goldMineProblem.calculateUsingRecursion());
        System.out.println("calculating max gold using memoization \t\t\t: " + goldMineProblem.calculateUsingMemoization());
        System.out.println("calculating max gold using tabulation \t\t\t: " + goldMineProblem.calculateGoldUsingTabulation());
    }
}
