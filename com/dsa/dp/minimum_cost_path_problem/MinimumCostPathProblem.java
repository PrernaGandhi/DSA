package com.dsa.dp.minimum_cost_path_problem;

import java.util.Map;

/*
        We have a matrix, where each cell value represents the cost
        of travelling through the cell. We need to calculate the
        minimum cost to travel from (0, 0) to (m - 1, n - 1 )
        where m is number of rows, and n is number of columns
        of a m * n matrix

         ---------- ---------- ---------- ---------- ----------
        |     3    |     2    |    12    |    15    |    10    |
         ---------- ---------- ---------- ---------- ----------
        |     6    |    19    |     7    |    11    |    17    |
         ---------- ---------- ---------- ---------- ----------
        |     8    |     5    |    12    |    32    |    21    |
         ---------- ---------- ---------- ---------- ----------
        |     3    |    20    |     2    |     9    |     7    |
         ---------- ---------- ---------- ---------- ----------

         Memoization: (top - down approach)
         we start to find the solution going from the top to bottom
         the smallest sub problem exists in the bottom
 initial
 --->          3    ->     2    ->    12    ->    15    ->    10
 problem       |           |           |          |           |
               V           V           V          V           V
               6    ->    19    ->     7    ->    11    ->    17
               |           |           |          |           |
               V           V           V          V           V
               8    ->     5    ->    12    ->    32    ->    21
               |           |           |          |           |
               V           V           V          V           V
               3    ->    20    ->     2    ->    9    ->     7     ---> smallest sub problem


         Lookup table :

         Key        |               Value
         3,4        |                 7
         3,3        |       9 + val(3,4) = 9 + 7 = 16
         3,2        |       2 + val(3,3) = 2 + 16 = 18
         3,1        |       20 + val(3,2) = 20 + 18 = 38
         3,0        |       3 + val(3,1) = 3 + 38 = 41
         2,4        |       21 + val(3,4) = 21 + 7 = 28
         2,3        |       32 + min(val(2,4),val(3,3)) = 32 + min(28,16) = 32 + 16 = 48
         2,2        |       12 + min(val(2,3),val(3,2)) = 12 + min(48,18) = 12 + 18 = 30


        Tabulation: (bottom - up approach)
        we start to find the solution going from the bottom to bottom
        the smallest sub problem exists in the bottom

 smallest
 --->          3    <-     2    <-    12    <-    15    <-   10
 sub           ^           ^           ^          ^           ^
 problem       |           |           |          |           |
               6    <-    19    <-     7    <-    11    <-    17
               ^           ^           ^          ^           ^
               |           |           |          |           |
               8    <-     5    <-    12    <-    32    <-    21
               ^           ^           ^          ^           ^
               |           |           |          |           |
               3    <-    20    <-     2    <-    9    <-     7     ---> initial sub problem


        DP table :
               3    <-     5    <-     17    <-   32    <-    42
               ^           ^           ^          ^           ^
               |           |           |          |           |
               9    <-    24    <-    24    <-    35    <-    52
               ^           ^           ^          ^           ^
               |           |           |          |           |
               17    <-    22    <-    34    <-   66    <-    87
               ^           ^           ^          ^           ^
               |           |           |          |           |
               20    <-   40    <-     36    <-   45    <-    52


        There is an optimized version of tabulation,
        all we need is the top data and the left one,
        so we don't need to have the entire dp table,
        we can work with only two rows


 */
public class MinimumCostPathProblem {
    int[][] matrix;
    int m;
    int n;

    public MinimumCostPathProblem(int[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
    }

    int calculateUsingRecursion(int x, int y) {
        // base case, last cell
        // simply return it's value
        if (x == m - 1 && y == n - 1) {
            return matrix[x][y];
        }
        if (x == m - 1) {
            // current cell cost + cost from right cell to the last cell
            return matrix[x][y] + calculateUsingRecursion(x, y + 1);
        }
        if (y == n - 1) {
            // current cell cost + cost from down cell to the last cell
            return matrix[x][y] + calculateUsingRecursion(x + 1, y);
        }
        // current cell cost + min of the cost from down cell and cost from right cell
        return matrix[x][y] + Math.min(calculateUsingRecursion(x, y + 1), calculateUsingRecursion(x + 1, y));
    }

    // memoization : top down approach
    // top - initial
    // down - smallest sub problem
    int calculateUsingMemoization(int x, int y, Map<String, Integer> lookupTable) {
        String key = x + ", " + y;
        // check if the lookup table consists of lookup table
        if (lookupTable.containsKey(key)) {
            return lookupTable.get(key);
        }

        if (x == m - 1 && y == n - 1) {
            int value = matrix[x][y];
            lookupTable.put(key, value);
            return value;
        }
        if (x == m - 1) {
            int value = matrix[x][y] + calculateUsingMemoization(x, y + 1, lookupTable);
            lookupTable.put(key, value);
            return value;
        }
        if (y == n - 1) {
            int value = matrix[x][y] + calculateUsingMemoization(x + 1, y, lookupTable);
            lookupTable.put(key, value);
            return value;
        }
        int value = matrix[x][y] + Math.min(calculateUsingMemoization(x, y + 1, lookupTable),
                calculateUsingMemoization(x + 1, y, lookupTable));
        lookupTable.put(key, value);
        return value;
    }

    // tabulation : bottom up approach
    // starting from bottom,
    // smallest sub problem is at the top
    int calculateUsingTabulation() {
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        // fill the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }
        // fill the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // current cell cost + min (cost of above row, cost of previous column)
                //                               top                    left
                dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }

    /*
        We just need two rows instead of the whole dp table
     */
    int calculateOptimizedTabulation() {
        // for storing values of current row
        int[] dp = new int[n];
        // for storing values of current row
        int[] prevDp = new int[n];
        // populate the first value
        prevDp[0] = matrix[0][0];

        // populate the first row
        for (int i = 1; i < n; i++) {
            // populate prev dp array using matrix
            prevDp[i] = prevDp[i - 1] + matrix[0][i];
        }

        // traverse row
        for (int i = 1; i < m; i++) {
            // populate the first value
            dp[0] = prevDp[0] + matrix[i][0];
            // traverse column
            for (int j = 1; j < n; j++) {
                // current value plus minimum of left cell and top cell
                dp[j] = matrix[i][j] + Math.min(prevDp[j], dp[j - 1]);
            }
            // replace previous row with current row
            prevDp = dp;
        }
        return dp[n - 1];
    }
}
