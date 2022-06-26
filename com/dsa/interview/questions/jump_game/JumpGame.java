package com.dsa.interview.questions.jump_game;

/*
        Starting from first index, reach the last step

        Example 1 :   [2, 3, 1, 1, 4]

        [2, 3, 1, 1, 4]
                     ^
                     |
                    good index

        [2, 3, 1, 1, 4]
                  ^
                  |
        index + arr[index] = 3 + 1 = 4 >= 4, so 3 is good index

        [2, 3, 1, 1, 4]
               ^
               |
        index + arr[index] = 2 + 1 = 3 >= 3, so 2 is good index

        [2, 3, 1, 1, 4]
            ^
            |
        index + arr[index] = 1 + 1 = 2 >= 2, so 1 is good index

        [2, 3, 1, 1, 4]
         ^
         |
       index + arr[index] = 0 + 2 = 2 >= 1, so 0 is good index

       if 0 is good index, we can reach the last step

        Output : true


      Example 2 :   [3, 2, 1, 0, 4]

        [3, 2, 1, 0, 4]
                     ^
                     |
                    good index

        [3, 2, 1, 0, 4]
                  ^
                  |
        index + arr[index] = 3 + 0 = 3 <= 4, so 3 is bad index

        [3, 2, 1, 0, 4]
               ^
               |
        index + arr[index] = 2 + 1 = 3 <= 4, so 2 is bad index

        [3, 2, 1, 0, 4]
            ^
            |
        index + arr[index] = 1 + 2 = 3 >= 4, so 1 is bad index

        [3, 2, 1, 0, 4]
         ^
         |
       index + arr[index] = 0 + 3 = 3 >= 4, so 0 is bad index

       if 0 is bad index, we cannot reach the last step

       Output : false

 */
public class JumpGame {
    public boolean isPossible(int[] arr) {
        int n = arr.length;
        int goodPosition = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (i + arr[i] >= goodPosition) {
                goodPosition = i;
            }
        }
        if (goodPosition == 0) {
            return true;
        }
        return false;
    }
}
