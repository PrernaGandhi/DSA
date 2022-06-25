package com.dsa.interview.questions.search_in_rotated_sorted_array;

public class Runner {
    public static void main(String[] args) {
        SearchElementInRotatedSortedArray searchElementInRotatedSortedArray = new SearchElementInRotatedSortedArray();
        int[] arr = {5, 6, 7, 8, 9, 1, 2, 3, 4};
        System.out.println(searchElementInRotatedSortedArray.find(arr, 3));
        arr = new int[]{5, 6, 7, 8, 9, 1, 2, 3, 4};
        System.out.println(searchElementInRotatedSortedArray.find(arr, 30));
        arr = new int[]{4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println(searchElementInRotatedSortedArray.find(arr, 0));
    }
}
