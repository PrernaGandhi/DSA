package com.dsa.interview.questions.rotate_matrix;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        int[][] arr = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        Arrays.stream(rotateMatrix.rotate(arr)).map(Arrays::toString).forEach(System.out::println);
        System.out.println();
        arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Arrays.stream(rotateMatrix.rotate(arr)).map(Arrays::toString).forEach(System.out::println);
        System.out.println();
        arr = new int[][]{
                {1, 2},
                {3, 4}
        };
        Arrays.stream(rotateMatrix.rotate(arr)).map(Arrays::toString).forEach(System.out::println);
    }
}
