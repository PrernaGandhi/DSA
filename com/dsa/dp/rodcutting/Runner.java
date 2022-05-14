package com.dsa.dp.rodcutting;

public class Runner {
    public static void main(String[] args) {
        int []price = {0, 2, 5, 7, 3, 9};
        RodCutting problem = new RodCutting(price, 5);
        System.out.println(problem.solution());
       problem.showSolution();
    }
}
