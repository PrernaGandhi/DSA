package com.dsa.sorting.merge_sort;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {7, 3, 1, 5, 6, 2, 4};
        mergeSort.sort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
