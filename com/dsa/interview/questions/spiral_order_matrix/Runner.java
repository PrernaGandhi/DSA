package com.dsa.interview.questions.spiral_order_matrix;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        SpiralOrderMatrix spiralOrderMatrix = new SpiralOrderMatrix();
        Arrays.stream(spiralOrderMatrix.traverse(arr)).forEach(e -> System.out.print(e + " "));

        System.out.println();
        arr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        Arrays.stream(spiralOrderMatrix.traverse(arr)).forEach(e -> System.out.print(e + " "));
    }
}
