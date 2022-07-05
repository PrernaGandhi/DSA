package com.dsa.dp.target_sum;

import java.util.HashMap;
import java.util.Map;

/*
    Given an array and a target sum,
    we need to use all elements of the array
    to make the target sum
    operations we can use --> + or -

    Example :   [1,1,1,1,1]     target sum = 3
    Output : 5, there are 5 ways to make target sum from the given array

    -1+1+1+1+1 = 3
    +1-1+1+1+1 = 3
    +1+1-1+1+1 = 3
    +1+1+1-1+1 = 3
    +1+1+1+1-1 = 3
 */
public class TargetSum {

    private int findPaths(int[] arr, int currIndex, int currTotal, int targetSum) {
        if (currIndex == arr.length && currTotal == targetSum) {
            return 1;
        }
        if (currIndex == arr.length && currTotal != targetSum) {
            return 0;
        }
        int path1 = findPaths(arr, currIndex + 1, currTotal + arr[currIndex], targetSum);
        int path2 = findPaths(arr, currIndex + 1, currTotal - arr[currIndex], targetSum);
        return path1 + path2;
    }

    public int findPaths(int[] arr, int targetSum) {
        return findPaths(arr, 0, 0, targetSum);
    }

    private int findPathsDP(int[] arr, int currIndex, int currTotal, int targetSum, Map<String, Integer> map) {
        if (currIndex == arr.length) {
            if (currTotal == targetSum) {
                return 1;
            } else {
                return 0;
            }
        }
        String key = currIndex + "," + currTotal;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        map.put(key, findPathsDP(arr, currIndex + 1, currTotal + arr[currIndex], targetSum, map)
                + findPathsDP(arr, currIndex + 1, currTotal - arr[currIndex], targetSum, map));
        return map.get(key);
    }

    public int findPathsDP(int[] arr, int targetSum) {
        Map<String, Integer> map = new HashMap<>();
        return findPathsDP(arr, 0, 0, targetSum, map);
    }
}
