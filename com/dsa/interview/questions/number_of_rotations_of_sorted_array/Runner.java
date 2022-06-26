package com.dsa.interview.questions.number_of_rotations_of_sorted_array;

public class Runner {
    public static void main(String[] args) {
        NumberOfRotationsOfSortedArray numberOfRotationsOfSortedArray = new NumberOfRotationsOfSortedArray();
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(numberOfRotationsOfSortedArray.countRotations(arr));
        arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(numberOfRotationsOfSortedArray.countRotations(arr));

    }
}
