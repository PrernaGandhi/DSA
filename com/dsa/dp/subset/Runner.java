package com.dsa.dp.subset;

public class Runner {
    public static void main(String[] args) {
        // int [] values = {1, 7, 4, 3, 6, 5, 9, 11};
        // int sum = 43;
        int [] values = {3,4,5};
        int sum = 10;
        SubsetProblem subsetProblem = new SubsetProblem(sum, values );
        subsetProblem.solve();
        subsetProblem.showResult();
    }
}
