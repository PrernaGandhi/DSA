package com.dsa.sorting.bubble_sort;

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

        iteration 4
        1   2   3   4   5
        <--->
        1   2   3   4   5
            <--->
        1   2   3   4   5
                <--->
        1   2   3   4   5
                    <--->
        1   2   3   4   5

        so after 4th iteration,
        the fourth largest number, i.e, 2,
        reaches it's correct position like a bubble

 */
public class BubbleSort {
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
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
