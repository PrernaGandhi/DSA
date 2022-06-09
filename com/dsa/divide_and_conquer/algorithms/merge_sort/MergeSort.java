package com.dsa.divide_and_conquer.algorithms.merge_sort;

/*
    Sort given array of integers with the help of merge sort

                                        [5, -1, 0, 7, 2, 3, 2, 1, 0, 1, 2]
                                                /                \
                                    [5, -1, 0, 7, 2]          [3, 2, 1, 0, 1, 2]
                                       /      \                    /        \
                                  [5, -1]    [0, 7, 2]        [3, 2, 1]    [0, 1, 2]
                                   /  \         /  \            /  \           / \
                                 [5]  [-1]    [0]  [7, 2]     [3]   [2, 1]   [0]   [1, 2]
                                 /      \     /     /   \     /     /   \    /      /  \
                                [5]    [-1]  [0]   [7]  [2]  [3]   [2]  [1] [0]   [1]  [2]
                                 \     /     /      \    /   /      \   /   /      \    /
                                 [-1, 5]   [0]      [2, 7]  [3]    [1, 2]  [0]     [1, 2]
                                    \      /           \    /        \     /          |
                                   [-1, 0, 5]         [2, 3, 7]     [0, 1, 2]      [1, 2]
                                        \               /               \            /
                                       [-1, 0, 2, 3, 5, 7]              [0, 1, 1, 2, 2]
                                                 \                           /
                                              [-1, 0, 0, 1, 1, 2, 2, 2, 3, 5, 7]
*/

public class MergeSort {
    private int[] nums;

    private int[] tempArray;

    public MergeSort(int[] nums) {
        this.nums = nums;
        this.tempArray = new int[nums.length];
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sort() {
        mergeSort(0, nums.length - 1);
    }

    private void mergeSort(int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return;

        // find the middle index
        int middleIndex = (startIndex + endIndex) / 2;

        // splitting the problems into sub and sub-problems
        // until it contains only one array
        // sort the first half of the array
        mergeSort(startIndex, middleIndex);
        // sort the second half of the array
        mergeSort(middleIndex + 1, endIndex);
        // merge both arrays
        merge(startIndex, middleIndex, endIndex);
    }

    private void merge(int startIndex, int middleIndex, int endIndex) {
        // making a copy of the original array
        for (int i = startIndex; i <= endIndex; i++)
            tempArray[i] = nums[i];

        // counter for 1st half of array
        int i = startIndex;
        // counter for second half of array
        int j = middleIndex + 1;
        // counter for the main array
        int k = startIndex;

        while (i <= middleIndex && j <= endIndex) {
            // if element of 1st half of array is smaller than
            // element of 2nd half of array
            if (tempArray[i] < tempArray[j]) {
                nums[k] = tempArray[i];
                // we increment the counter for the 1st half of array
                ++i;
            } else {
                nums[k] = tempArray[j];
                // we increment the counter for 2nd half of the array
                ++j;
            }
            k++;
        }

        // if size of 1st half of array is greater
        // than size of 2nd half of array
        // it means there are still elements left
        // in 1st half of the array
        // so copying over to the original array
        while (i <= middleIndex) {
            nums[k] = tempArray[i];
            k++;
            i++;
        }

        // if size of 2nd half of array is greater
        // than size of 1st half of array
        // it means there are still elements left
        // in 2nd half of the array
        // so copying over to the original array
        while (j <= endIndex) {
            nums[k] = tempArray[j];
            k++;
            j++;
        }
    }

    public void showArray() {
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " ");
        }
    }
}
