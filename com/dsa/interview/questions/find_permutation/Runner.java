package com.dsa.interview.questions.find_permutation;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        FindPermutation findPermutation = new FindPermutation();
        int[] arr = {1, 2, 3};
        Arrays.stream(findPermutation.findPermutation(arr, "ID")).forEach(e -> System.out.print(e + " "));
        System.out.println();
        Arrays.stream(findPermutation.findPermutation(arr, "II")).forEach(e -> System.out.print(e + " "));
        System.out.println();
        Arrays.stream(findPermutation.findPermutation(arr, "DD")).forEach(e -> System.out.print(e + " "));
        System.out.println();
        arr = new int[]{1, 2, 3, 4, 5};
        Arrays.stream(findPermutation.findPermutation(arr, "DIDD")).forEach(e -> System.out.print(e + " "));
    }
}
