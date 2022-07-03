package com.dsa.interview.questions.k_sorted_array;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        int[] arr = {10, 12, 15, 6, 9};
        KSortedArray kSortedArray = new KSortedArray();
        kSortedArray.kSortedArray(arr, 3);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{10, 12, 6, 7, 9};
        kSortedArray.kSortedArray(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
