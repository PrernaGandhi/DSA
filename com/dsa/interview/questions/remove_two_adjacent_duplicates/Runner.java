package com.dsa.interview.questions.remove_two_adjacent_duplicates;

public class Runner {
    public static void main(String[] args) {
        RemoveTwoAdjacentDuplicates removeTwoAdjacentDuplicates = new RemoveTwoAdjacentDuplicates();
        System.out.println(removeTwoAdjacentDuplicates.removeAdjacentDuplicates("aab"));
        System.out.println(removeTwoAdjacentDuplicates.removeAdjacentDuplicates("aa"));
        System.out.println(removeTwoAdjacentDuplicates.removeAdjacentDuplicates("baab"));
        System.out.println(removeTwoAdjacentDuplicates.removeAdjacentDuplicates("aaa"));
        System.out.println(removeTwoAdjacentDuplicates.removeAdjacentDuplicates("aaabccddd"));
        System.out.println(removeTwoAdjacentDuplicates.removeAdjacentDuplicates("mississippi"));
    }
}
