package com.dsa.interview.questions.find_permutation;

/*
        I means Increase -> next number should be greater
        D means Decrease -> next number should be smaller

        String would be of length N - 1

        N       |       String          |    Output
   -------------|-----------------------|----------------
        3       |       ID              |   [1, 3, 2]
        3       |       II              |   [1, 2, 3]
        3       |       DD              |   [3, 2, 1]
        5       |       DIDD            |   [5, 1, 4, 3, 2]

        Approach : If we encounter I, then we choose the smallest number for current index,
        as the next number we want should be greater than the previous number.
        If we encounter D, we choose the largest number for the current index,
        as the next number we want should be less than the previous number.

 */
public class FindPermutation {
    public int[] findPermutation(int[] arr, String string) {
        int[] answer = new int[arr.length];
        int start = 0;
        int end = arr.length - 1;
        int currIndex = 0;
        while (currIndex < arr.length) {
            if (currIndex == arr.length - 1) {
                answer[currIndex] = arr[start];
            } else if (string.charAt(currIndex) == 'D') {
                answer[currIndex] = arr[end];
                end--;
            } else if (string.charAt(currIndex) == 'I') {
                answer[currIndex] = arr[start];
                start++;
            }
            currIndex++;
        }
        return answer;
    }
}
