package com.dsa.dp.minimum_steps_to_one;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        MinimumStepsToOne minimumStepsToOne = new MinimumStepsToOne();
        int n = 7;
        System.out.println(minimumStepsToOne.minimumStepsToOne(n));
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        System.out.println(minimumStepsToOne.minimumStepsToOneMemoized(n, arr));
        n = 10;
        System.out.println(minimumStepsToOne.minimumStepsToOne(n));
        arr = new int[n + 1];
        Arrays.fill(arr, -1);
        System.out.println(minimumStepsToOne.minimumStepsToOneMemoized(n, arr));
    }
}
