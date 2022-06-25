package com.dsa.sorting.merge_sort;

import java.util.Arrays;
/*
                7   3   1   5   6   2   4
                        /           \
            7   3   1   5          6   2   4
              /       \               /    \
          7   3      1   5          6   2    4
          /  \         /  \         /  \      \
         7    3       1    5       6     2     4
          \  /         \  /          \  /       \
         3   7         1   5        2   6       4
            \          /                \       /
            1   3   5   7               2   4   6
                    \                   /
                  1   2   3   4   5   6   7
 */
public class MergeSort {
    public int[] sort(int[] arr, int start, int end) {
        // start > end, means 0 elements
        // start = end means 1 element
        if (start >= end) {
            return arr;
        }

        // find mid
        int mid = (start + end) / 2;
        // sort first half of array
        sort(arr, start, mid);
        // sort second half of array
        sort(arr, mid + 1, end);
        // merge the two sorted array
        merge(arr, start, mid, end);
        return arr;
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int arrayOneStart = start;
        int index = start;
        int arrayTwoStart = mid + 1;
        // copy all elements to a temporary array
        // so that we can make changes to the existing array
        // using the temporary array
        int[] temp = Arrays.copyOf(arr, arr.length);

        while (arrayOneStart <= mid && arrayTwoStart <= end) {
            if (temp[arrayOneStart] < temp[arrayTwoStart]) {
                arr[index] = temp[arrayOneStart];
                arrayOneStart++;
            } else {
                arr[index] = temp[arrayTwoStart];
                arrayTwoStart++;
            }
            index++;
        }

        // for remaining elements of first array
        while (arrayOneStart <= mid) {
            arr[index] = temp[arrayOneStart];
            index++;
            arrayOneStart++;
        }
        // for remaining elements of second array
        while (arrayTwoStart <= end) {
            arr[index] = temp[arrayTwoStart];
            index++;
            arrayTwoStart++;
        }
    }
}