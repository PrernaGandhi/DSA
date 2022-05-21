package com.dsa.interview.questions.trapping_rain_water_problem;

public class Runner {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 1, 5};
        TrappingRainWaterProblem problem = new TrappingRainWaterProblem();
        System.out.println(problem.solve(arr));
        arr = new int[]{1, 0, 2, 1, 3, 1, 2, 0, 3};
        System.out.println(problem.solve(arr));
        arr = new int[]{2, 3};
        System.out.println(problem.solve(arr));
    }
}
