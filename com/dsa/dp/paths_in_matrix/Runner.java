package com.dsa.dp.paths_in_matrix;

import java.util.HashMap;

public class Runner {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0},
        };
        PathsInMatrix pathsInMatrix = new PathsInMatrix(matrix);
        System.out.println("Paths in matrix using recursion \t\t\t\t:\t" + pathsInMatrix.pathsUsingRecursion(0, 0));
        pathsInMatrix = new PathsInMatrix(matrix);
        System.out.println("Paths in matrix using memoization \t\t\t\t:\t" + pathsInMatrix.pathsUsingMemoization(0, 0, new HashMap<>()));
        pathsInMatrix = new PathsInMatrix(matrix);
        System.out.println("Paths in matrix using tabulation \t\t\t\t:\t" + pathsInMatrix.pathsUsingTabulation());
        pathsInMatrix = new PathsInMatrix(matrix);
        System.out.println("Paths in matrix using optimized tabulation \t\t:\t" + pathsInMatrix.pathsUsingOptimizedTabulation());

    }
}
