package com.dsa.sorting.selection_sort;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] array = {7, 5, 3, 6, 8};
        selectionSort.sort(array);
        Arrays.stream(array).forEach(System.out::println);
    }
}
