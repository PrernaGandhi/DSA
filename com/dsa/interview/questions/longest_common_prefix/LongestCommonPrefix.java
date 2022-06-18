package com.dsa.interview.questions.longest_common_prefix;

/*
Input :
    [   "abcdef",
        "aefghij",
        "abcefg"
    ]
Output :
        "a"

Input :
    [   "flower",
        "flow",
        "flight"
    ]
Output :
        "fl"

Input :
    [   "dog",
        "racecar",
        "car"
    ]
Output :
        ""

Input :
    [   "geeksforgeeks",
        "geeks",
        "geeks",
        "geezer"
    ]
Output :
        "gee"

 */
public class LongestCommonPrefix {

    public String getLongestCommonPrefix(String[] strings) {
        int min = Integer.MAX_VALUE;
        // find length of the shortest string
        // O(N)
        for (String string : strings) {
            if (string.length() < min) {
                min = string.length();
            }
        }

        StringBuilder prefix = new StringBuilder();
        // O(mN) where m is length of smallest string
        // and N is no of strings
        for (int i = 0; i < min; i++) {
            for (String string : strings) {
                if (prefix.length() < i + 1) {
                    prefix.append(string.charAt(i));
                }
                if (string.charAt(i) != prefix.charAt(i)) {
                    prefix = new StringBuilder(prefix.substring(0, i));
                    return prefix.toString();
                }
            }
        }
        return prefix.toString();
    }
}
