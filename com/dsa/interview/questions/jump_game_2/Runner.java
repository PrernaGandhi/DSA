package com.dsa.interview.questions.jump_game_2;

public class Runner {
    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] arr = {1, 4, 3, 7, 1, 2, 6, 7, 6, 10};
        System.out.println(jumpGame.countSteps(arr));
        arr = new int[]{2, 3, 1, 1, 4};
        System.out.println(jumpGame.countSteps(arr));
        arr = new int[]{3, 2, 1, 0, 4};
        System.out.println(jumpGame.countSteps(arr));
    }
}
