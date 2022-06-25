package com.dsa.sorting.quick_sort;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {8, 5, 2, 1, 7, 3, 4, 6};
        quickSort.quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
