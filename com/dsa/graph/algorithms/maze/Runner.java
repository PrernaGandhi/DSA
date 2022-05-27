package com.dsa.graph.algorithms.maze;

public class Runner {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 1, 1, 1, 1, 1},
                {2, 1, 1, 1, 0, 1},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 3},
        };
        maze = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {2, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 3},
        };
        maze = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {2, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 1, 3},
        };

        Maze problem = new Maze(maze, 1, 0);
        problem.findWay();
    }
}
