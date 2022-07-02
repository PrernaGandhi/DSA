package com.dsa.interview.questions.two_sum_with_sorted_array;

/*
            [1, 4, 6, 8, 10, 45]        target = 16
            [1, 2, 3, 4, 6]             target = 10
            [2, 7, 11, 15]              target = 9

            Approach 1:
                Pick one element
                Search for another element
                (use binary search for searching)
                Time complexity : O(NlogN)
                Space complexity : O(1)

            Approach 2:
                Two pointer approach
                start pointer and end pointer
                sum == target element, return
                sum > target element, end--
                sum < target element, start++
                Time complexity : O(N)
                Space complexity : O(1)
 */
public class TwoSumWithSortedArray {

    public int[] find(int[] arr, int target) {
        int startPointer = 0;
        int endPointer = arr.length - 1;
        int[] ans = new int[2];
        while (startPointer < endPointer) {
            int sum = arr[startPointer] + arr[endPointer];
            if (sum == target) {
                ans[0] = arr[startPointer];
                ans[1] = arr[endPointer];
                return ans;
            } else if (sum > target) {
                endPointer--;
            } else {
                startPointer++;
            }
        }
        return ans;
    }
}
