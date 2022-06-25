package com.dsa.interview.questions.first_and_last_occurance_of_element;

/*
    Find the first and last occurrence of element in a sorted array

            Array           |   Element |   First Occurrence    |   Last Occurrence
    ------------------------|-----------|-----------------------|--------------------------
    [1,3,5,5,5,5,67,123,125]|       5   |           2           |           5
    [1,3,5,5,5,5,7,123,125] |       7   |           6           |           6
        [5,7,7,8,8,10]      |       8   |           3           |           4
        [5,7,7,8,8,10]      |       6   |          -1           |          -1


    Approach 1: Bruteforce approach
                Time complexity : O(N)
                Space complexity : O(1)
    Approach 2: Binary Search

 */
public class FirstAndLastOccurrenceOfElement {

    public int getIndexOfFirstOccurrenceOfElement(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                ans = mid;
                // we need to check if in the left half
                // we have any more target values
                end = mid - 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public int getIndexOfLastOccurrenceOfElement(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                ans = mid;
                // we need to check if in the right half
                // we have any more target values
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
