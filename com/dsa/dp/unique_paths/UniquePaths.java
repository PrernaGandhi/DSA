package com.dsa.dp.unique_paths;

/*
        Given m * n matrix we need to reach from
        (0,0) to (m-1,n-1)

        the only two options is to move forward or move downward

        we need to find how many unique paths are possible


        now we can solve this using permutations,

        why permutations? bcoz the order matters.
        if I choose to go to the extreme right and then
        down, and
        if I choose to go extreme down and then right,
        it would be two different paths,

        so number of ways would be (M-1 + N-1)P(M-1 + N-1) ==> (M+N-2)!

        but, we have duplicates, if we travel two
        times right, and swap those right moves,
        we won't be able to tell the difference

        so we have repetition for right and down
        so we have M - 1 right repetitions and
        N - 1 down repetitions,

        So no of unique ways  =>  (M+N-2)!
                                ------------
                                (M-1)!(N-1)!


 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}
