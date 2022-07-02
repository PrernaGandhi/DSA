package com.dsa.interview.questions.two_sum;

import java.util.HashMap;
import java.util.Map;

/*

        Given an array and a target sum we need to find the
        two numbers that add up to the target sum

        [4, 7, 2, 9, 13, 5, 3]
        target value = 12

        Approach 1 :
            Bruteforce approach :
                pick one element in the array A[i],
                then find target - A[i] in the array
                Time complexity : O(N*N)
                Space complexity : O(1)

        Approach 2 :
            HashMap approach :
                pick one element in the array, store in
                HashMap and search if target - A[i] is
                present in the map,
                (In hashmap, searching is O(N))
                Time complexity : O(N)
                Space complexity : O(N)
 */
public class TwoSum {
    public int[] findTwoNumbers(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                ans[0] = arr[i];
                ans[1] = target - arr[i];
                return ans;
            }
            map.put(arr[i], i);
        }
        return ans;
    }
}
