package maze_problem;

/*
    From a source location we need to reach the destination location
    We need to find a valid path from source to the destination
    The maze contains boulders also

   ____________________________
  |   Move   |    X   |    Y   |
  |----------|--------|--------|
  | forward  |    1   |    0   |
  | backward |   -1   |    0   |
  |   down   |    0   |    1   |
  |    up    |    0   |   -1   |
   ----------------------------

    Maze Board :
      ___ ___ ___ ___
   ->|_S_|___|___|___|
     |___|_X_|___|_X_|
     |_X_|_X_|___|___|
     |___|_X_|___|_D_|->

     Step 1: Forward
      ___ ___ ___ ___
   ->|-->|___|___|___|
     |___|_X_|___|_X_|
     |_X_|_X_|___|___|
     |___|_X_|___|___|->

     Step 2: Forward
      ___ ___ ___ ___
   ->|-->|-->|___|___|
     |___|_X_|___|_X_|
     |_X_|_X_|___|___|
     |___|_X_|___|___|->

    Step 3: Forward
      ___ ___ ___ ___
   ->|-->|-->|-->|___|
     |___|_X_|___|_X_|
     |_X_|_X_|___|___|
     |___|_X_|___|___|->

    Step 4: Forward
      ___ ___ ___ ___
   ->|-->|-->|-->|-->|
     |___|_X_|___|_X_|
     |_X_|_X_|___|___|
     |___|_X_|___|___|->

    Step 5: End of maze, so check downwards, not possible, then backwards
      ___ ___ ___ ___
   ->|-->|-->|-->|   |
     |___|_X_|___|_X_|
     |_X_|_X_|___|___|
     |___|_X_|___|___|->

     Step 6: Downwards
      ___ ___ ___ ___
   ->|-->|-->|-->|___|
     |___|_X_| | |_X_|
     |_X_|_X_|___|___|
     |___|_X_|___|___|->

    Step 7: Downwards
      ___ ___ ___ ___
   ->|-->|-->|-->|___|
     |___|_X_| | |_X_|
     |_X_|_X_| | |___|
     |___|_X_|___|___|->

    Step 7: Downwards
      ___ ___ ___ ___
   ->|-->|-->|-->|___|
     |___|_X_| | |_X_|
     |_X_|_X_| | |___|
     |___|_X_|_v_|___|->

    Step 7: Forward
      ___ ___ ___ ___
   ->|---------> |___|
     |___|_X_| | |_X_|
     |_X_|_X_| | |___|
     |___|_X_|_v_|-->|->


 */
public class MazeProblem {
    // 0  -- means valid path
    // -1 -- means boulder
    // 1  -- means solution
    private final int[][] mazeBoard;
    private final int size;
    int[] xMoves = {1, -1, 0, 0};
    int[] yMoves = {0, 0, 1, -1};

    public MazeProblem(int[][] mazeBoard) {
        this.mazeBoard = mazeBoard;
        this.size = mazeBoard.length;
    }

    public void solve() {
        mazeBoard[0][0] = 1;
        if (solution(0, 0)) {
            showSolution();
        } else {
            System.out.println("There is no possible solution ... ");
        }
    }

    private boolean solution(int x, int y) {
        // this means we reached the corner, our end destination
        if (x == mazeBoard.length - 1 && y == mazeBoard.length - 1) {
            return true;
        }

        for (int i = 0; i < xMoves.length; i++) {
            int nextX = x + xMoves[i];
            int nextY = y + yMoves[i];

            // if the next move is a valid move,
            // then we try to find the next valid move
            if (isValid(nextX, nextY)) {
                // valid move
                mazeBoard[nextX][nextY] = 1;

                if (solution(nextX, nextY)) {
                    return true;
                }

                // BACKTRACK
                mazeBoard[nextX][nextY] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int x, int y) {
        // check if x is not outside the maze board
        if (x < 0 || x >= size)
            return false;
        // check if y is not outside the maze board
        if (y < 0 || y >= size)
            return false;
        // check if there is a boulder
        if (mazeBoard[x][y] == -1)
            return false;
        // check if already part of the solution
        if (mazeBoard[x][y] == 1)
            return false;
        return true;
    }

    private void showSolution() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // -1 represents boulder
                if (mazeBoard[i][j] == -1) {
                    System.out.print(" ! ");
                // 1 represents that it is part of the solution
                } else if (mazeBoard[i][j] == 1) {
                    System.out.print(" * ");
                // 0 represents a valid space
                } else {
                    System.out.print(" _ ");
                }
            }
            System.out.println();
        }
    }
}
