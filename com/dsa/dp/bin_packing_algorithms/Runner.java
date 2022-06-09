package com.dsa.dp.bin_packing_algorithms;

import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        // List<Integer> list = Arrays.asList(5,5,5);
        // int binCapacity = 5;
        // List<Integer> list = Arrays.asList(5,5,5);
        // int binCapacity = 3;
        List<Integer> list = Arrays.asList(3, 2, 4, 2, 1);
        int binCapacity = 5;
        FirstFitDecreasingProblem algorithm = new FirstFitDecreasingProblem(list, binCapacity);
        algorithm.solve();
        algorithm.showResults();
    }
}
