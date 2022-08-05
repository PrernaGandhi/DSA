package com.dsa.dp.paths_in_matrix;

import java.util.Map;

/*
        [0, 0, 1, 0, 1]
        [0, 0, 0, 0, 1]
        [0, 0, 1, 0, 0]
        [1, 0, 0, 0, 0]

        m*n matrix
        if 0,0 is 1 or m-1,n-1 is 1, there is no possible path

        0
        |
        V
        0
        |
        V
        0  ---> 0
        |       |
        V       V
        X       0 ---> 0 ---> 0 ---> 0

        base cases :
        m - 1, n - 1 == 0 -> 1
        x,y == 1 or x == m or y == n -> 0
 */
public class PathsInMatrix {

    private final int[][] matrix;
    private final int m;
    private final int n;

    public PathsInMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
    }

    int pathsUsingRecursion(int x, int y) {
        if (x == m || y == n || matrix[x][y] == 1) {
            return 0;
        }
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        return pathsUsingRecursion(x, y + 1) + pathsUsingRecursion(x + 1, y);
    }

    int pathsUsingMemoization(int x, int y, Map<String, Integer> lookupTable) {
        String key = x + ", " + y;
        if (lookupTable.containsKey(key)) {
            return lookupTable.get(key);
        }
        if (x == m || y == n || matrix[x][y] == 1) {
            lookupTable.put(key, 0);
            return 0;
        }
        if (x == m - 1 && y == n - 1) {
            lookupTable.put(key, 1);
            return 1;
        }
        int value = pathsUsingMemoization(x, y + 1, lookupTable) + pathsUsingMemoization(x + 1, y, lookupTable);
        lookupTable.put(key, value);
        return value;
    }

    int pathsUsingTabulation() {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        // populate first row
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 1) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }
        // populate first column
        for (int j = 1; j < m; j++) {
            if (matrix[j][0] == 1) {
                dp[j][0] = 0;
            } else {
                dp[j][0] = dp[j - 1][0];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    int pathsUsingOptimizedTabulation() {
        int[] dp = new int[n];
        int[] prevDp = new int[n];

        prevDp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 1) {
                prevDp[i] = 0;
            } else {
                prevDp[i] = prevDp[i - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 1) {
                dp[0] = 0;
            } else {
                dp[0] = prevDp[0];
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] = prevDp[j] + dp[j - 1];
                }
            }
            prevDp = dp;
        }
        return dp[n - 1];
    }
}
