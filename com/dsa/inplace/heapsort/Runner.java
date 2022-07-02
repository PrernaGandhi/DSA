package com.dsa.inplace.heapsort;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = {10, 5, 8, 1, 4};
        heapSort.sort(arr);
        Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
    }
}
