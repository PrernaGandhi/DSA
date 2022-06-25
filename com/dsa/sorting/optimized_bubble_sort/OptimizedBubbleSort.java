package com.dsa.sorting.optimized_bubble_sort;

/*
        In each k iterations, the k th largest element reaches it's correct position

        arr ->  5   4   3   1   2

        iteration 1

        5   4   3   1   2
        <--->
        4   5   3   1   2
            <--->
        4   3   5   1   2
                <--->
        4   3   1   5   2
                    <--->
        4   3   1   2   5

        so after 1st iteration,
        the first largest number, i.e, 5,
        reaches it's correct position like a bubble

        Now we check if flag == 0, which is false,
        so we continue.

        iteration 2

        4   3   1   2   5
        <--->
        3   4   1   2   5
            <--->
        3   1   4   2   5
                <--->
        3   1   2   4   5
                    <--->
        3   1   2   4   5

        so after 2nd iteration,
        the second largest number, i.e, 4,
        reaches it's correct position like a bubble

        Now we check if flag == 0, which is false,
        so we continue.

        iteration 3
        3   1   2   4   5
        <--->
        1   3   2   4   5
            <--->
        1   2   3   4   5
                <--->
        1   2   3   4   5
                    <--->
        1   2   3   4   5

        so after 3rd iteration,
        the third largest number, i.e, 3,
        reaches it's correct position like a bubble

        Now we check if flag == 0, which is true,
        which means array is already sorted,
        hence we come out of the program
 */
public class OptimizedBubbleSort {
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int flag = 0;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = 1;
                }
            }
            // after each iteration we check if the flag is 0,
            // it means array is sorted
            // as we are setting flag to 1
            // after swapping the elements
            if (flag == 0) {
                break;
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
