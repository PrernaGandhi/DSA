package com.dsa.dp.grid_path;

/*
        Given an m*n grid, find the number of unique paths from starting to end position
        Constraints:
            We can only move right or down

        Example :
            grid(2, 4)
             __ __ __ __
            |__|__|__|__|
            |__|__|__|__|

            __                  __ __                __ __ __            __ __ __ __
           |__|__ __ __        |__|__|__ __         |__|__|__|__        |__|__|__|__|
           |__|__|__|__|          |__|__|__|              |__|__|                |__|

           so 4 paths



           Steps:
                1. what can be the simplest input ?
                    grid(1,1) -> 0
                     __
                    |__|

                    let's take a look at more of these examples
                    grid(2,1) -> 1
                     __ __
                    |__|__|

                    grid(3,1) -> 1
                     __ __ __
                    |__|__|__|

                    grid(4,1) -> 1
                     __ __ __ __
                    |__|__|__|__|

                    grid(1,2) -> 1
                     __
                    |__|
                    |__|

                    grid(1,3) -> 1
                     __
                    |__|
                    |__|
                    |__|


                    grid(1,3) -> 1
                     __
                    |__|
                    |__|
                    |__|
                    |__|

                   We notice an interesting thing,
                   whenever the value of either of the input is 1,
                   we only have one unique path


                   so base case ==> if m==1 || n==1 , return 1

                 __ __           __        __ __
                |__|__|    =>   |__|    + |__|__|    => 2
                |__|__|         |__|


                __ __ __        __ __     __ __ __
               |__|__|__|  =>  |__|__| + |__|__|__|
               |__|__|__|      |__|__|

                          =>     2 + 1
                          =>     2 + 1
                          =>     3

            2.   Play with examples and visualize
 */
public class GridPath {

    public int countPaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        } else {

            return countPaths(m - 1, n) + countPaths(m, n - 1);
        }
    }
}
