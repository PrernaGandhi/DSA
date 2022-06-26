package com.dsa.interview.questions.sqrt_of_a_number;

/*
    We need to find the sqrt of a number
    We only need to find the integer part,
    we can truncate the decimal part

        Input   |   Output
   -------------|---------------
        4       |      2
        8       |      2
        10      |      3


        Approach 1: Naive Approach
            Input => Sqrt(50) = 7
                      x
            1, 2, ........ , X^2  < 50

            Time Complexity : O(Sqrt(N))
            Space Complexity : O(1)

        Approach 2: Binary Search
            Input => Sqrt(10) = 3

 */
public class SqrtOfNumber {
    public int sqrt(int number) {
        int start = 1;
        int end = number;
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid * mid > number) {
                end = mid - 1;
            }
            // we have a potential answer
            // when square of mid is less
            // than number
            else {
                answer = mid;
                start = mid + 1;
            }
        }
        return answer;
    }
}
