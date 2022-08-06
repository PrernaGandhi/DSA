package com.dsa.dp.house_robber_problem;

import java.util.HashMap;

public class Runner {
    public static void main(String[] args) {
        int[] array = {2, 10, 3, 6, 8, 1, 7};
        HouseRobberProblem houseRobberProblem = new HouseRobberProblem(array);
        System.out.println("Maximum amount stolen using recursion \t\t\t\t:\t" + houseRobberProblem.robUsingRecursion(0));
        houseRobberProblem = new HouseRobberProblem(array);
        System.out.println("Maximum amount stolen using memoization \t\t\t:\t" + houseRobberProblem.robUsingMemoization(0, new HashMap<>()));
        houseRobberProblem = new HouseRobberProblem(array);
        System.out.println("Maximum amount stolen using tabulation \t\t\t\t:\t" + houseRobberProblem.robUsingTabulation());
        houseRobberProblem = new HouseRobberProblem(array);
        System.out.println("Maximum amount stolen using optimized tabulation \t:\t" + houseRobberProblem.robUsingOptimizedTabulation());

    }
}
