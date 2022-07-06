package com.dsa.dp.work_break;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.isPresentInDictionary("leet", Arrays.asList("leet", "code")));
        System.out.println(wordBreak.isPresentInDictionary("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak.isPresentInDictionary("leeetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak.isPresentInDictionary("leeet", Arrays.asList("leet", "code")));
        System.out.println(wordBreak.isPresentInDictionary("code", Arrays.asList("leet", "code")));
    }
}
