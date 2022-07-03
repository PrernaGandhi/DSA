package com.dsa.dp.minimum_steps_to_one;

/*
        From a value n we need to go to 1
        Operations allowed :
            Decrement by 1
            Divide by 2, only if number is divisible by 2
            Divide by 3, only if number is divisible by 3


        Approach 1: Bruteforce (wrong approach)
            try to divide by 3,
            try to divide by 2,
            otherwise decrement by 1


            example : n = 10
            if we go by bruteforce approach

            10 is divisible by 3, no
            divisible by 2, yes
            10 / 2 = 5 ====> step1
            now is 5 divisible by 3, no
            is 5 divisible by 2, no
            then decrement by 1
            5 - 1 = 4, ======> step2
            is 4 divisible by 3, no
            is 4 divisible by 2, yes
            4 / 2 = 2 ========> step3
            is 2 divisible by 3, no
            is 2 divisible by 2, yes
            2 / 2 = 1, =======> step4

            in reality,
            step 1 : 10 - 1 = 9
            step 2 : 9 / 3 = 3
            step 3 : 3 / 3 = 1

 */
public class MinimumStepsToOne {
    public int minimumStepsToOne(int n) {
        if (n == 1) {
            return 0;
        }

        int x = minimumStepsToOne(n - 1);
        int y = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            y = minimumStepsToOne(n / 2);
        }

        int z = Integer.MAX_VALUE;
        if (n % 3 == 0) {
            z = minimumStepsToOne(n / 3);
        }
        return 1 + Math.min(x, Math.min(y, z));
    }

    public int minimumStepsToOneMemoized(int n, int[] arr) {
        if (n == 1) {
            return 0;
        }

        if (arr[n] != -1) {
            return arr[n];
        }
        int x = minimumStepsToOneMemoized(n - 1, arr);
        int y = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            y = minimumStepsToOneMemoized(n / 2, arr);
        }

        int z = Integer.MAX_VALUE;
        if (n % 3 == 0) {
            z = minimumStepsToOneMemoized(n / 3, arr);
        }
        int output = 1 + Math.min(x, Math.min(y, z));
        arr[n] = output;
        return output;
    }

    public int minimumStepsToOneBottomUp(int n) {
        if (n == 1) {
            return 0;
        }
        int[] arr = new int[n + 1];
        for (int i = 2; i < arr.length; i++) {

            int x = arr[i - 1];
            int y = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                y = arr[i / 2];
            }

            int z = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                z = arr[i / 3];
            }
            arr[i] = 1 + Math.min(x, Math.min(y, z));
        }
        return arr[n];
    }
}
