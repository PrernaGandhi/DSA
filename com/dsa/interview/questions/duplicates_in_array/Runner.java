package com.dsa.interview.questions.duplicates_in_array;

public class Runner {
    public static void main(String[] args) {
        int [] arr = {1,5,2,8,3,6,1,6,2,2, 1, 3, 5};
        DuplicatesProblem duplicatesProblem = new DuplicatesProblem();
        duplicatesProblem.solve(arr);
        duplicatesProblem.solveWithUsingExtraMemory(arr);
    }
}
