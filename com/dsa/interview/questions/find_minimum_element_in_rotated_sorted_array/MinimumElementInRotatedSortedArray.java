package com.dsa.interview.questions.find_minimum_element_in_rotated_sorted_array;

/*
    Find minimum element in rotated sorted array

    Assumptions : No Duplicate elements

            Array       |       Output
     -------------------|---------------------
          [3,4,5,1,3]   |           1
        [4,5,6,7,0,1,2] |           0

    Approach 1: Bruteforce Approach
                Linear Search
                Time complexity = O(N)
                Space complexity = O(1)

    Approach 2: Binary Search

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

 */
public class MinimumElementInRotatedSortedArray {

    public int minimumElement(int[] arr) {
        int start = 0;
        int n = arr.length;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            // mod n is required so that we don't
            // overflow from the array
            int next = (mid + 1) % n;
            // +n and then mod n is required so that
            // we don't underflow from the array
            int prev = (mid - 1 + n) % n;

            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                return arr[mid];
            } else if (arr[mid] < arr[end]) {
                end = mid - 1;
            } else if (arr[mid] > arr[start]) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
