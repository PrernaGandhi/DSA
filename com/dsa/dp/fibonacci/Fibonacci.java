package com.dsa.dp.fibonacci;

import java.util.Map;

/*
    Fibonacci series : 0 1 1 2 3 5 8 13 21
 */
public class Fibonacci {

    public int fibonacciRecursion(int n) {
        // base case
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    // top bottom approach, start from N -> 0
    // table is pre-computed with base case values
    // recursive solution
    public int fibonacciMemoization(int n, Map<Integer, Integer> table) {
        if (!table.containsKey(n)) {
            table.put(n, fibonacciMemoization(n - 1, table) + fibonacciMemoization(n - 2, table));
        }
        return table.get(n);
    }

    // bottom up approach, start from 0 -> N
    // iterative approach
    public int fibonacciTabulation(int n, Map<Integer, Integer> table) {
        for (int i = 2; i <= n; i++)
            table.put(i, table.get(i - 1) + table.get(i - 2));
        return table.get(n);
    }
}