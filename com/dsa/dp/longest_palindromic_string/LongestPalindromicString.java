package com.dsa.dp.longest_palindromic_string;

import java.util.HashMap;
import java.util.Map;

/*
Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

"a"     "a"

"ab"    "a"
"aa"    "aa"
"ba"    "b"
"aba"   "aba"
if s > e
return string
if s == e
we insert at currIndex aba
                        ^
                        |


 */
public class LongestPalindromicString {
    // O(2^n)
    private String find(String string, String output, int startIndex, int endIndex) {
        if (string.length() == 1) {
            return string;
        }
        if (startIndex > endIndex) {
            return output;
        }
        if (isPalindrome(string, startIndex, endIndex)) {
            output = string.substring(startIndex, endIndex + 1);
        }
        String res1 = find(string, output, startIndex, endIndex - 1);
        if (output.length() < res1.length()) {
            output = res1;
        }
        String res2 = find(string, output, startIndex + 1, endIndex);
        if (output.length() < res2.length()) {
            output = res2;
        }
        System.out.println("------" + output + "  " + startIndex + "  " + endIndex);
        return output;
    }

    // O(N)
    public String find(String string) {
        return find(string, "", 0, string.length() - 1);
    }

    // O(n^n)
    private String findDP(String string, String output, int startIndex, int endIndex, Map<String, String> map) {
        String key = startIndex + " " + endIndex;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (string.length() == 1) {
            return string;
        }
        if (startIndex > endIndex) {
            return output;
        }
        if (isPalindrome(string, startIndex, endIndex)) {
            output = string.substring(startIndex, endIndex + 1);
            map.put(key, output);
        }
        String res1 = findDP(string, output, startIndex, endIndex - 1, map);
        if (output.length() < res1.length()) {
            output = res1;
            map.put(key, output);
        }
        String res2 = findDP(string, output, startIndex + 1, endIndex, map);
        if (output.length() < res2.length()) {
            output = res2;
            map.put(key, output);
        }
        return output;
    }

    // O(N)
    public String findDP(String string) {
        Map<String, String> map = new HashMap<>();
        return findDP(string, "", 0, string.length() - 1, map);
    }

    private boolean isPalindrome(String string, int startIndex, int endIndex) {
        while (startIndex <= endIndex) {
            if (string.charAt(startIndex) != string.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
}