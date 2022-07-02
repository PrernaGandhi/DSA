package com.dsa.interview.questions.two_sum_with_sorted_array;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 10, 45};
        int targetSum = 16;
        TwoSumWithSortedArray twoSumWithSortedArray = new TwoSumWithSortedArray();
        System.out.println(Arrays.toString(twoSumWithSortedArray.find(arr, targetSum)));
        arr = new int[]{1, 2, 3, 4, 6};
        targetSum = 10;
        System.out.println(Arrays.toString(twoSumWithSortedArray.find(arr, targetSum)));

        arr = new int[]{2, 7, 11, 15};
        targetSum = 9;
        System.out.println(Arrays.toString(twoSumWithSortedArray.find(arr, targetSum)));

    }
}
