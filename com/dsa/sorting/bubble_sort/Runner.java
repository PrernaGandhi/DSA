package com.dsa.sorting.bubble_sort;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {5, 4, 3, 1, 2};
        bubbleSort.sort(array);
        Arrays.stream(array).forEach(System.out::println);
        System.out.println("--------------------------");
        array = new int[]{5, 4, 3, 2, 1};
        bubbleSort.sort(array);
        Arrays.stream(array).forEach(System.out::println);
    }
}
