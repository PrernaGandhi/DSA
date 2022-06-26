package com.dsa.interview.questions.single_number;

/*
        Every element in the array will appear twice except one number
        and our task is to find that one number which appears only once

        Input Array     |       Output
   ---------------------|--------------------
        [2,2,1]         |       1
        [4,1,2,1,2]     |       4
        [1,2,2,3,1]     |       3

        Approach 1: Sort the array and then iterate over the array
                Time complexity : O(nlogn + n) = O(nlogn)
                Space complexity : O(1)

        Approach 2: store in HashMap, then iterate over the hashmap,
                    with value equals 1, we have our answer
                Time complexity : O(n + n) = O(n)
                Space complexity : O(n)

        Approach 3: X-or Approach

            Truth table for X - or (if elements are same, output is 0)

                A   |   B   | Output
            --------|-------|---------
                0   |   0   |   0
                0   |   1   |   1
                1   |   0   |   1
                1   |   1   |   0

        Properties of X-or
            1.  A^A = 0
            2.  A^0 = A
            3.  A^B^A = A^A^B = 0^B = B

 */
public class SingleNumber {
    public int singleNumber(int[] arr) {
        int result = 0;
        for (int element :
                arr) {
            result = result ^ element;
        }
        return result;
    }
}
