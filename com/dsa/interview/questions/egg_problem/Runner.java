package com.dsa.interview.questions.egg_problem;

public class Runner {
    public static void main(String[] args) {
        int noOfEggs = 2;
        int noOfFloors = 10;
        EggProblem eggProblem = new EggProblem(noOfEggs, noOfFloors);
        System.out.println(eggProblem.solveRecursive(2, 10));
        System.out.println(eggProblem.solveMemoizedRecursive(2, 10));
    }
}
