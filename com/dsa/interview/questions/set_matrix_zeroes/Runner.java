package com.dsa.interview.questions.set_matrix_zeroes;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 4, 1, 0},
                {3, 2, 1, 5},
                {4, 0, 7, 2}
        };
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        Arrays.stream(setMatrixZeroes.setZeroes(arr)).map(Arrays::toString).forEach(System.out::println);
        arr = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        System.out.println();
        Arrays.stream(setMatrixZeroes.setZeroes(arr)).map(Arrays::toString).forEach(System.out::println);
        arr = new int[][]{
                {1, 0, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        System.out.println();
        Arrays.stream(setMatrixZeroes.setZeroes(arr)).map(Arrays::toString).forEach(System.out::println);
    }
}
