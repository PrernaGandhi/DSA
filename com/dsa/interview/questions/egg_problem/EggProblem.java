package com.dsa.interview.questions.egg_problem;

public class EggProblem {
    private int numberOfEggs;
    private int numberOfFloors;
    private int[][] dpTable;

    public EggProblem(int numberOfEggs, int numberOfFloors) {
        this.numberOfEggs = numberOfEggs;
        this.numberOfFloors = numberOfFloors;
        this.dpTable = new int[numberOfEggs + 1][numberOfFloors + 1];
    }
    public void solveProblem() {

    }

    public int solveRecursive(int numberOfEggs, int numberOfFloors) {
        // base case
        if(numberOfFloors == 1 || numberOfFloors == 0) {
            return numberOfFloors;
        }
        if(numberOfEggs == 0) {
            return numberOfFloors;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= numberOfFloors; i++) {
            int eggBreaks = solveRecursive(numberOfEggs - 1, i - 1);
            int eggDoesnotBreaks = solveRecursive(numberOfEggs, numberOfFloors - i);
            int res = Math.max(eggBreaks, eggDoesnotBreaks);
            if(res < min) {
                min = res;
            }
        }
        return 1 + min;
    }

    public int solveMemoizedRecursive(int numberOfEggs, int numberOfFloors) {
        if(dpTable[numberOfEggs][numberOfFloors] != 0) {
            return dpTable[numberOfEggs][numberOfFloors];
        }
        if(numberOfFloors == 1 || numberOfFloors == 0 || numberOfEggs == 0) {
            return numberOfFloors;
        }
        if(numberOfEggs == 1) {
            return numberOfFloors;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= numberOfFloors; i++) {
            int eggBreaks = solveMemoizedRecursive(numberOfEggs - 1,i - 1);
            int eggDoesnotBreak = solveMemoizedRecursive(numberOfEggs, numberOfFloors - i);
            int res = Math.max(eggBreaks, eggDoesnotBreak);
            if(res < min) {
                min = res;
            }
        }
        dpTable[numberOfEggs][numberOfFloors] = min + 1;
        return dpTable[numberOfEggs][numberOfFloors];
    }
}
