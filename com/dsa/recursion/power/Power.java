package com.dsa.recursion.power;

/*
        Calculate x3 - 5*5*5 = 125

        Steps:
        1.  Base case
        2.  Calculate for n - 1
        3.  Calculate for n
 */
public class Power {
    public int calculate(int number, int power) {
        // base case
        if (power == 0) {
            return 1;
        }

        // calculate for f(n-1)
        int result = calculate(number, power - 1);

        // calculate for f(n)
        return number * result;

    }
}
