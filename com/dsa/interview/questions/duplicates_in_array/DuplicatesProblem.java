package com.dsa.interview.questions.duplicates_in_array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesProblem {
    /*
    The problem is that we want to find duplicates in a
    one-dimensional array of integers in O(N) running time
    where the integer values are smaller than the length of the array!
     */
    private List<Integer> list;
    public void solve(int [] arr) {
        Set<Integer> set = new HashSet<>();
        list = new ArrayList<>();
        for(Integer num : arr) {
            if(!set.contains(num)) {
                set.add(num);
            } else if(!list.contains(num)){
                list.add(num);
            }
        }
        showResult();
    }

    private void showResult() {
        for(Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // since values are less than size of array
    public void solveWithUsingExtraMemory(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[Math.abs(arr[i])] > 0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            } else {
                System.out.print(Math.abs(arr[i]) + " ");
            }
        }
    }


}
