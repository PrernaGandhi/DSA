package maze_problem;

public class MazeProblem {
    // 0  -- means valid path
    // -1 -- means boulder
    // 1  -- means solution
    private final int[][] mazeBoard;
    private final int size;
    int [] xMoves = {1, -1, 0, 0};
    int [] yMoves = {0, 0, 1, -1};

    public MazeProblem(int [][] mazeBoard) {
        this.mazeBoard = mazeBoard;
        this.size = mazeBoard.length;
    }

    public void solve() {
        mazeBoard[0][0] = 1;
        if(solution(0, 0)) {
            showSolution();
        } else {
            System.out.println("There is no possible solution ... ");
        }
    }

    private boolean solution(int x, int y) {
        // this means we reached the corner, our end destination
        if(x == mazeBoard.length - 1 && y == mazeBoard.length - 1) {
            return true;
        }

        for(int i = 0; i< xMoves.length; i++) {
            int nextX = x + xMoves[i];
            int nextY = y + yMoves[i];
            if(isValid(nextX, nextY)) {
                // valid move
                mazeBoard[nextX][nextY] = 1;

                if(solution(nextX, nextY)) {
                    return true;
                }

                // BACKTRACK
                mazeBoard[nextX][nextY] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int x, int y) {
        // check if it not outside the maze board
        if( x < 0 || x >= size)
            return false;
        if(y < 0 || y >= size)
            return false;
        // check if there is a boulder
        if(mazeBoard[x][y] == -1)
            return false;
        // check if already visited
        if(mazeBoard[x][y] == 1)
            return false;
        return true;
    }

    private void showSolution(){
        for(int i = 0; i < size; i ++) {
            for( int j = 0; j < size; j++) {
                if(mazeBoard[i][j] == -1) {
                    System.out.print(" ! ");
                } else if( mazeBoard[i][j] == 1) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" _ ");
                }
            }
            System.out.println();
        }
    }
}
