package com.dsa.dp.subset;

import java.util.ArrayList;
import java.util.HashMap;

public class Runner {
    public static void main(String[] args) {
        int[] values = {1, 7, 4, 3, 6, 5, 9, 11};
        int sum = 43;
        int index = 0;
        // int [] values = {3,4,5};
        // int sum = 10;
        //index = values.length - 1;
        SubsetProblem subsetProblem;
        //subsetProblem = new SubsetProblem(sum, values);
        //subsetProblem.solve();
        //subsetProblem.showResult();

        //values = new int[]{0, 1, 7, 4, 3, 6, 5, 9, 11};
        //sum = 43;
        //values = new int[]{0, 3, 4, 5};
        //sum = 10;
        //index = values.length - 1;
        //subsetProblem = new SubsetProblem(sum, values);
        //System.out.println(subsetProblem.solveRecursive(sum, index));

        values = new int[]{0, 1, 7, 4, 3, 6, 5, 9, 11};
        sum = 43;
        //values = new int[]{0, 3, 4, 5};
        //sum = 10;
        values = new int[]{0, 3, 4, 7};
        sum = 10;
        index = values.length - 1;
        subsetProblem = new SubsetProblem(sum, values);
        System.out.println(subsetProblem.solveMemoizedRecursive(sum, index, new HashMap<>()));
        subsetProblem.showResult();
    }
}
