package com.dsa.dp.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        // it has exponential running time
        System.out.println(fibonacci.fibonacciRecursion(12));
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 1);
        // it has O(N) linear running time
        System.out.println(fibonacci.fibonacciMemoization(12, map));
        System.out.println(fibonacci.fibonacciTabulation(12, map));
    }
}
