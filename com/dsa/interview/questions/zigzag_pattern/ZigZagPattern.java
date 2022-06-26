package com.dsa.interview.questions.zigzag_pattern;

import java.util.Arrays;

/*
        Input String => "PAYPALISHIRING"
        No of rows => 4

        row 1   |   P                       I                       N
        row 2   |       A               L       S               I       G
        row 3   |           Y       A               H       R
        row 4   |               P                       I

        Output => PINALSIGYAHRPI
 */
public class ZigZagPattern {

    public String convert(String string, int numberOfRows) {
        String[] strings = new String[numberOfRows];
        Arrays.fill(strings, "");
        int index = 0;
        int row = 0;
        int step = 1;
        while (index < string.length()) {
            strings[row] += string.charAt(index);
            if (row == 0) {
                step = 1;
            } else if (row == numberOfRows - 1) {
                step = -1;
            }
            index++;
            row = row + step;
        }

        StringBuilder ans = new StringBuilder();
        for (String currentString : strings) {
            ans.append(currentString);
        }
        return ans.toString();
    }
}
