package com.dsa.dp.rodcutting;

public class Runner {
    public static void main(String[] args) {
        int[] price = {0, 2, 5, 7, 3, 9};
        int rodLength = 5;
        RodCutting problem = new RodCutting(price, rodLength);
        System.out.println(problem.solution());
        problem.showSolution();

        problem = new RodCutting(price, rodLength);
        System.out.println(problem.solveRecursive(rodLength, rodLength));

        problem = new RodCutting(price, rodLength);
        System.out.println(problem.solveMemoizedRecursive(rodLength, rodLength));
        problem.showSolution();
    }
}
