package com.dsa.interview.questions.single_number;

public class Runner {
    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] arr = {2, 2, 1};
        System.out.println(singleNumber.singleNumber(arr));
        arr = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber.singleNumber(arr));
        arr = new int[]{1, 2, 2, 3, 1};
        System.out.println(singleNumber.singleNumber(arr));

    }
}
