package com.dsa.interview.questions.number_of_rotations_of_sorted_array;

/*
    To find number of rotations of a sorted array
    - we need to count number of elements before
    the minimum element, i.e, index of minimum element,
    as index starts from 0

        ^    prev
      5 |    /|
        |   / |
      4 |  /  |
        | /   |
      3 |/    |
        |s    |   e
      2 |     |  /
        |     | /
      1 |     |/ next
        +-------------------->
             mid

        1   2   3   4   5
        --->--->--->--->
                |  1st rotation
                v
        5   1   2   3   4
        --->--->--->--->
                |   2nd rotation
                v
        4   5   1   2   3

        Two rotations are made
        so two elements got added in the front
 */
public class NumberOfRotationsOfSortedArray {

    public int countRotations(int[] arr) {
        int start = 0;
        int n = arr.length;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int next = (mid + 1) % n;
            int prev = (mid - 1 + n) % n;
            if (arr[mid] < arr[prev] && arr[mid] < arr[next]) {
                return mid;
            } else if (arr[mid] < arr[end]) {
                end = mid - 1;
            } else if (arr[start] < arr[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
