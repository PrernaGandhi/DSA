package com.dsa.interview.questions.anagram;

import java.util.*;

public class AnagramProblem {

    // O(N) running time complexity with additional memory
    public boolean solve(String str1, String str2) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : str1.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        for (Character ch : str2.toCharArray()) {
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }
        return true;
    }

    // O(NlogN)
    public boolean solveWithoutUsingExtraMemory(char[] str1, char[] str2) {
        if(str1.length != str2.length) {
            return false;
        }
        // O(NlogN)
        Arrays.sort(str1);
        Arrays.sort(str2);

        //O(N)
        for(int i = 0; i < str1.length;i++) {
            if(str1[i] != str2[i]) {
                return false;
            }
        }
        return true;
    }
}
