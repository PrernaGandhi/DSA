package com.dsa.sorting.selection_sort;

/*
        arr ->  7   5   6   3   8

        Selection sort says that find the smallest array element
        in right hand side and swap with the current element


        7   5   3   6   8
        ^
        |
        i |---------------->
            find smallest element here

           smallest element is 3,
           compare with 7
           swap with the element at i

        3   5   7   6   8
            ^
            |
            i |------------>
               find the smallest element here

               smallest element is 6,
               compare with 5,
               do nothing

        3   5   7   6   8
                ^
                |
                i |-------->
                    find the smallest element here

                    smallest element is 6,
                    compare with 7,
                    swap with the element at i

        3   5   6   7   8
                    ^
                    |
                    i |--->
                        find the smallest element here

                        smallest element is 8,
                        compare with 7,
                        do nothing


        Sorted array :  3   5   6   7   8

Time complexity : N^2
 */
public class SelectionSort {

    public int[] sort(int[] inputArray) {
        for (int i = 0; i < inputArray.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[j] < inputArray[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swap(inputArray, i, minElementIndex);
        }
        return inputArray;
    }

    private void swap(int[] arr, int i, int minElementIndex) {
        int temp = arr[i];
        arr[i] = arr[minElementIndex];
        arr[minElementIndex] = temp;
    }
}
