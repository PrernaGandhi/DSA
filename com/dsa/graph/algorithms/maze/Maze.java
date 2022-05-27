package com.dsa.graph.algorithms.maze;

public class Maze {

    private int[][] maze;

    private boolean[][] visited;

    private int startRow;

    private int startColumn;

    public Maze(int[][] maze, int startRow, int startColumn) {
        this.maze = maze;
        this.visited = new boolean[maze.length][maze.length];
        this.startRow = startRow;
        this.startColumn = startColumn;
    }

    public void findWay() {
        if (dfs(startRow, startColumn)) {
            System.out.println("We found the solution");
        } else {
            System.out.println("There is no solution");
        }
    }

    private boolean isFeasible(int x, int y) {
        // out of the maze board
        if (x < 0 || x > maze.length - 1)
            return false;
        // out of the maze board
        if (y < 0 || y > maze.length - 1)
            return false;
        // we have already considered that state
        if (visited[x][y])
            return false;
        // there is an obstacle in the way
        if(maze[x][y] == 1)
            return false;

        return true;
    }

    private boolean dfs(int x, int y) {
        if(x == maze.length - 1 && y == maze.length - 1)
            return true;

        if(isFeasible(x, y)) {
            visited[x][y] = true;

            // go down
            if(dfs(x + 1,y))
                return true;

            // go up
            if(dfs(x - 1, y))
                return true;

            // go right
            if(dfs(x, y + 1))
                return true;

            // go left
            if(dfs(x, y - 1))
                return true;

            // BACKTRACK
            visited[x][y] = false;
            return false;
        }
        return false;
    }

}
