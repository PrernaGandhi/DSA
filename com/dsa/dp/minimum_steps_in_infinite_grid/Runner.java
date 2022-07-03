package com.dsa.dp.minimum_steps_in_infinite_grid;

public class Runner {
    public static void main(String[] args) {

        int[] x = {1, 3, 3, 5};
        int[] y = {2, 3, 5, 4};

        MinimumStepsInInfiniteGrid minimumStepsInInfiniteGrid = new MinimumStepsInInfiniteGrid();
        System.out.println(minimumStepsInInfiniteGrid.minimumStepsRequired(x, y));
    }
}
