package com.dsa.dp.minimum_steps_in_infinite_grid;

/*
        Minimum Steps in an infinite grid
        given a starting point and an ending point,
        we need to find number of steps to reach from
        starting point to ending point

        possible moves -> 8 directions

                   \  |  /
                    \ | /
            ------ [x, y] ------
                    / | \
                   /  |  \

        Example :
            (1, 2)  (3, 3)  (3, 5)  (5, 4)
            start                    end

            Using the given points calculate minimum number of steps required
            ^
            |
            |
          5 -                          o
            |                          ^  \
            |                        4 |    \ 5     6
          4 -                          ^      \ -------->o
            |                        3 |
            |                     2    |
          3 -              / --------->o
            |         1  /
            |          /
          2 -        o
            |
            |
          1 -
            |
            |
            +--------|--------|--------|--------|--------|-------->
                     1        2        3        4        5

            Total steps taken : 6

        Approach :

            To reach from x1, y1 to x2, y2
            no of steps would be Max(abs(x1 - x2), abs(y1 - y2))


 */
public class MinimumStepsInInfiniteGrid {

    int minimumStepsRequired(int[] x, int[] y) {
        int numberOfSteps = 0;
        for (int i = 0; i < x.length - 1; i++) {
            int j = i + 1;
            numberOfSteps += Math.max(Math.abs(x[i] - x[j]), Math.abs(y[i] - y[j]));
        }
        return numberOfSteps;
    }
}
