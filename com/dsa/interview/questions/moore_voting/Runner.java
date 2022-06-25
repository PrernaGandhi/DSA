package com.dsa.interview.questions.moore_voting;

public class Runner {
    public static void main(String[] args) {
        MooreVoting mooreVoting = new MooreVoting();
        int[] arr = {4, 7, 4, 4, 7, 4, 4, 9, 4, 3};
        System.out.println(mooreVoting.find(arr));
        arr = new int[]{3, 2, 3};
        System.out.println(mooreVoting.find(arr));
        arr = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(mooreVoting.find(arr));
        arr = new int[]{2, 2, 1, 1, 1, 1, 2, 2, 1};
        System.out.println(mooreVoting.find(arr));
        arr = new int[]{2, 2, 1, 1, 1, 1, 1, 2, 2};
        System.out.println(mooreVoting.find(arr));
    }
}
