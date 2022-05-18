package com.dsa.interview.questions.integer_reversion;

public class IntegerReversion {
    /*
    Our task is to design an efficient algorithm
    to reverse a given integer. For example if the
    input of the algorithm is 1234 then the output should be 4321.
     */

    // time complexity is equal to number of digits in the input
    public int integerReversion(int integer) {
        int noOfDigits = countNoOfDigits(integer);
        int output = 0;
        while (noOfDigits > 0) {
            int val = integer % 10;
            output += Math.pow(10, noOfDigits - 1) * val;
            integer = integer / 10;
            noOfDigits--;
        }
        return output;
    }

    public int integerReversionOptimized(int integer) {
        int output = 0;
        while (integer > 0) {
            int val = integer % 10;
            output = output * 10 + val;
            integer = integer / 10;
        }
        return output;
    }

    private int countNoOfDigits(int integer) {
        int count = 0;
        int val = integer;
        while (val != 0) {
            val = val / 10;
            count++;
        }
        return count;
    }
}
