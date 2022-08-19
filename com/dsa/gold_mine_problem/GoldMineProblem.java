package com.dsa.gold_mine_problem;

import java.util.HashMap;
import java.util.Map;

/*
    Gold mine (problem)
    Given a mine of n rows and m columns where mine[i][j] represents the amount of gold
    that is present there, we want to enter from the top of the mine and take as much gold
    as possible when exiting from the bottom, knowing that we can only move to the bottom,
    to the bottom-left, or to the bottom-right. We can exit from anywhere from the last row.

    Example:

    input:
    mine = [
       [3, 2, 12, 15, 10],
       [6, 19, 7, 11, 17],
       [8, 5, 12, 32, 21],
       [3, 20, 2, 9, 7]
    ]

    output: 73

    explanation: 15+17+32+9 = 73

    If I already know where to start from in the first row,
    I have 3 choices to go next bottom-left, bottom, bottom-right


            0                       i>m || j>n

    max in first row                i = 1        // for this we can call for all the
                                                 // elements from row 1 and choose the maximum

    matrix[i][j] + max(
    goldMine(bottom-left) +
    goldMine(bottom) +              otherwise
    goldMine(bottom-right))


 */
public class GoldMineProblem {

    private int[][] matrix;
    private int m;
    private int n;

    public GoldMineProblem(int[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
    }

    private int calculateMaxGoldUsingRecursion(int i, int j) {
        if (i == m || j == n || j < 0) {
            return 0;
        }
        return matrix[i][j]
                + Math.max(
                calculateMaxGoldUsingRecursion(i + 1, j - 1), // bottom left
                Math.max(calculateMaxGoldUsingRecursion(i + 1, j), // bottom
                        calculateMaxGoldUsingRecursion(i + 1, j + 1))); // bottom right
    }

    int calculateUsingRecursion() {
        int maxGold = 0;
        for (int j = 0; j < n; j++) {
            int value = calculateMaxGoldUsingRecursion(0, j);
            if (maxGold < value) {
                maxGold = value;
            }
        }
        return maxGold;
    }

    int calculateUsingMemoization() {
        int maxGold = 0;
        for (int j = 0; j < n; j++) {
            int value = calculateMaxGoldUsingMemoization(0, j, new HashMap<>());
            if (maxGold < value) {
                maxGold = value;
            }
        }
        return maxGold;
    }

    private int calculateMaxGoldUsingMemoization(int i, int j, Map<String, Integer> lookupTable) {
        String key = i + ", " + j;
        if (lookupTable.containsKey(key)) {
            return lookupTable.get(key);
        }
        if (i == m || j == n || j < 0) {
            return 0;
        }
        int value = matrix[i][j]
                + Math.max(
                calculateMaxGoldUsingMemoization(i + 1, j - 1, lookupTable), // bottom left
                Math.max(calculateMaxGoldUsingMemoization(i + 1, j, lookupTable), // bottom
                        calculateMaxGoldUsingMemoization(i + 1, j + 1, lookupTable))); // bottom right
        lookupTable.put(key, value);
        return value;
    }

    public int calculateGoldUsingTabulation() {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int topLeft = 0;
                int top = dp[i - 1][j];
                int topRight = 0;
                if ((j - 1) >= 0) {
                    topLeft = dp[i - 1][j - 1];
                }
                if ((j + 1) < n) {
                    topRight = dp[i - 1][j + 1];
                }
                dp[i][j] = matrix[i][j] + Math.max(topLeft, Math.max(top, topRight));
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            if (dp[m-1][i] > max) {
                max = dp[m-1][i];
            }
        }
        return max;
    }
}
