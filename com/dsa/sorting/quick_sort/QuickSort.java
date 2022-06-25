package com.dsa.sorting.quick_sort;

/*
        arr ->  8, 5, 2, 1, 7, 3, 4, 6

        pivot element --> 6

        i = 0, j = 0
        8 > 6, do nothing

        i = 0, j = 1
        5 < 6, swap (i, j)
        arr -> 5, 8, 2, 1, 7, 3, 4, 6

        i = 1, j = 2
        2 < 6, swap(i, j)
        arr -> 5, 2, 8, 1, 7, 3, 4, 6

        i = 2, j = 3
        1 < 6, swap(i, j)
        arr -> 5, 2, 1, 8, 7, 3, 4, 6

        i = 3, j = 4
        7 > 6, do nothing

        i = 3, j = 5
        3 < 6, swap(i, j)
        arr -> 5, 2, 1, 3, 7, 8, 4, 6

        i = 4, j = 6
        4 < 6, swap(i, j)
        arr -> 5, 2, 1, 3, 4, 8, 7, 6

        swap i and last element
        5   2   1   3   4   |   6   |   7   8
        sort element to left of pivot
        sort element to the right of pivot

 */
public class QuickSort {
    public int[] quickSort(int[] arr, int start, int end) {
        // start = end, only one element
        // start > end, no element
        if (start >= end) {
            return arr;
        }

        // get pivot element index
        int pivotIndex = partition(arr, start, end);
        // sort the left half
        quickSort(arr, start, pivotIndex - 1);
        // sort the right half
        quickSort(arr, pivotIndex + 1, end);
        return arr;
    }

    private int partition(int[] arr, int start, int end) {
        int i = start;
        // arr[end] is the pivot element
        for (int j = start; j < end; j++) {
            if (arr[j] < arr[end]) {
                swap(arr, i, j);
                i++;
            }
        }
        // place pivot element in the right position
        swap(arr, i, end);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
