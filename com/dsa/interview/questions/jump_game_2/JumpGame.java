package com.dsa.interview.questions.jump_game_2;

/*
    Count number of steps to reach the end

    we take two variables : curr ladder and biggest ladder

    Example 1 :
      1    2         3
     --->----->------------------>
    [1, 4, 3, 7, 1, 2, 6, 7, 6, 10]
      1
     --->     2
        ------------>
           --------->      3
               ----------------------->
                  --->
                     ------>
                        ------------------------>
                             -------------------------->
                                ---------------------------------->

      From 1, we take the biggest ladder available,
      then from 4, we take the biggest ladder available,
      then from 2, we take the biggest ladder available,
      then we reach the end

     Output - 3 steps taken


     Example 2 :

       1     2
      --->-------->
     [2, 3, 1, 1, 4]
        1
      ------>  2
         --------->
             --->
                --->

    From 2, we take the biggest ladder available,
    from 1, we take the biggest ladder available
    then we reach the end

    Output : 2 steps taken


    Example 3 :
         --------->
        [3, 2, 1, 0, 4]
         --------->
            ------>
               --->

        from 3, we take the longest ladder
        from 0, we don't have any ladders available

    Output : -1, we can't reach the last position
 */
public class JumpGame {
    public int countSteps(int[] arr) {
        int n = arr.length;
        // there is only one element
        // so there are no steps needed
        // to traverse from start to end
        // as start and end are same
        if (n == 1) {
            return 0;
        }
        // if the starting has value 0,
        // it means there is no way that
        // we can move ahead
        if (arr[0] == 0) {
            return -1;
        }
        int ladder = arr[0];    // biggest ladder / maximum reachable index
        int stair = arr[0];     // current ladder

        int jump = 1;           // count of steps taken

        for (int i = 1; i < n; i++) {
            if (i == n - 1) {   // we have reached the last index
                return jump;
            }
            // updating the biggest ladder at each index
            if (i + arr[i] > ladder) {
                ladder = i + arr[i];
            }
            stair--;    // traversing current ladder
            if (stair == 0) {   // current ladder finished
                jump++;
                // update the current ladder
                // based on number of steps
                // left in the biggest ladder
                // at the current index
                stair = ladder - i;
                if (stair <= 0) {
                    return -1;
                }
            }
        }
        return -1;
    }
}