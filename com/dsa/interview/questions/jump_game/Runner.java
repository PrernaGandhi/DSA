package com.dsa.interview.questions.jump_game;

public class Runner {
    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(jumpGame.isPossible(arr));
        arr = new int[]{3, 2, 1, 0, 4};
        System.out.println(jumpGame.isPossible(arr));
    }
}
