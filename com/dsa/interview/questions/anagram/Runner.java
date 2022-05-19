package com.dsa.interview.questions.anagram;

public class Runner {
    public static void main(String[] args) {
        AnagramProblem problem = new AnagramProblem();
        System.out.println(problem.solve("SADDER","DREADS"));
        System.out.println(problem.solve("SADER","DREADS"));
        System.out.println(problem.solveWithoutUsingExtraMemory("SADDER".toCharArray(),"DREADS".toCharArray()));
        System.out.println(problem.solveWithoutUsingExtraMemory("SADER".toCharArray(),"DREADS".toCharArray()));
    }
}
