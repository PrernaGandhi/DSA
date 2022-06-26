package com.dsa.interview.questions.find_minimum_element_in_rotated_sorted_array;

public class Runner {
    public static void main(String[] args) {
        MinimumElementInRotatedSortedArray minimumElementInRotatedSortedArray = new MinimumElementInRotatedSortedArray();
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(minimumElementInRotatedSortedArray.minimumElement(arr));
        arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(minimumElementInRotatedSortedArray.minimumElement(arr));
    }
}
