package com.dsa.interview.questions.two_sum;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] arr = {4, 7, 2, 9, 13, 5, 3};
        int target = 12;
        System.out.println(Arrays.toString(twoSum.findTwoNumbers(arr, target)));
    }
}
