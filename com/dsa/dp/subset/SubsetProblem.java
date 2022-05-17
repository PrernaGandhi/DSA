package com.dsa.dp.subset;

import java.util.Map;

public class SubsetProblem {
    private int sum;
    private int[] values;
    private boolean[][] dpTable;

    public SubsetProblem(int sum, int[] values) {
        this.sum = sum;
        this.values = values;
        this.dpTable = new boolean[values.length + 1][sum + 1];
        for (int i = 0; i < values.length + 1; i++)
            dpTable[i][0] = true;
    }

    public void solve() {
        // first row is false by default
        // so no need to set it
        // first row has false values
        // first column has true values
        for (int i = 0; i < values.length + 1; i++)
            dpTable[i][0] = true;

        for (int rowIndex = 1; rowIndex < values.length + 1; rowIndex++) {
            for (int colIndex = 1; colIndex < sum + 1; colIndex++) {
                // if colIndex is small , then we copy value above
                if (colIndex < values[rowIndex - 1]) {
                    dpTable[rowIndex][colIndex] = dpTable[rowIndex - 1][colIndex];
                } else {
                    if (dpTable[rowIndex - 1][colIndex]) {
                        // we don't include that item
                        dpTable[rowIndex][colIndex] = dpTable[rowIndex - 1][colIndex];
                    } else {
                        dpTable[rowIndex][colIndex] = dpTable[rowIndex - 1][colIndex - values[rowIndex - 1]];
                    }
                }
            }
        }
    }

    public boolean solveRecursive(int sum, int i) {
        if (sum == 0) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        if (sum < values[i]) {
            return solveRecursive(sum, i - 1);
        } else {
            return solveRecursive(sum - values[i], i - 1) || solveRecursive(sum, i - 1);
        }
    }

    // Memoized solution not working yet
    public boolean solveMemoizedRecursive(int sum, int i, Map<String, Boolean> lookup) {
        boolean result;
        String key = i + "|" + sum;
        if (sum == 0) {
            return true;
        } else if (i < 0 || sum < 0) {
            return false;
        } else if (sum < values[i]) {
            return dpTable[i][sum] = solveMemoizedRecursive(sum, i - 1, lookup);
        } else {
            if (
                    solveMemoizedRecursive(sum - values[i], i - 1, lookup) ||
                            solveMemoizedRecursive(sum, i - 1, lookup)) {
                return dpTable[i][sum] = true;
            } else {
                return dpTable[i][sum] = false;

            }
        }
        //  if (!lookup.containsKey(key)) {
        //     result = solveMemoizedRecursive(sum - values[i], i - 1, lookup) || solveMemoizedRecursive(sum, i - 1, lookup);
        //   lookup.put(key, result);
        //    dpTable[i][sum] = result;
        //}
        //int k1 = Integer.parseInt(key.split("\\|")[0]);
        //int k2 = Integer.parseInt(key.split("\\|")[1]);
        //dpTable[i][sum] = result;
        //lookup.put(key, result);
        //return dpTable[i][sum];
    }

    public void showResult() {
        System.out.println("There is a feasible solution " + dpTable[values.length][sum]);
        if (!dpTable[values.length][sum]) {
            return;
        }
        int colIndex = this.sum;
        int rowIndex = this.values.length;

        while (rowIndex > 0 || colIndex > 0) {
            if (dpTable[rowIndex][colIndex] == dpTable[rowIndex - 1][colIndex]) {
                rowIndex--;
            } else {
                System.out.println("We take the item : " + values[rowIndex - 1]);
                colIndex = colIndex - values[rowIndex - 1];
                rowIndex--;
            }
        }
    }
}
