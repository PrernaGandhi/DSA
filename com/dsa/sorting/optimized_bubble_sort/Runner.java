package com.dsa.sorting.optimized_bubble_sort;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        OptimizedBubbleSort optimizedBubbleSort = new OptimizedBubbleSort();
        int[] array = {5, 4, 3, 1, 2};
        optimizedBubbleSort.sort(array);
        Arrays.stream(array).forEach(System.out::println);
        System.out.println("--------------------------");
        array = new int[]{5, 4, 3, 2, 1};
        optimizedBubbleSort.sort(array);
        Arrays.stream(array).forEach(System.out::println);
    }
}
