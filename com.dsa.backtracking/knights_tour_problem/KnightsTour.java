package knights_tour_problem;

public class KnightsTour {
    private final int[][] chessBoard;
    private final int size;
    private final int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};

    public KnightsTour(int size) {
        this.size = size;
        this.chessBoard = new int[size][size];
        initializeChessBoard();
    }

    private void initializeChessBoard() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                chessBoard[i][j] = Integer.MIN_VALUE;
    }

    public void solve() {
        chessBoard[0][0] = 0;
        if (solution(1, 0, 0)) {
            showSolution();
        } else {
            System.out.println("There is no valid solution .... ");
        }
    }

    private boolean solution(int stepCount, int x, int y) {
        // if we have stepped on each of the box in the chess board,
        // it means that we have solved the problem
        if (stepCount == size * size) {
            return true;
        }
        for (int i = 0; i < xMoves.length; i++) {
            int nextX = x + xMoves[i];
            int nextY = y + yMoves[i];
            if (isValid(nextX, nextY)) {
                // update the chessboard if x and y co-ordinates are valid
                chessBoard[nextX][nextY] = stepCount;

                if (solution(stepCount + 1, nextX, nextY)) {
                    return true;
                }

                // BACKTRACK
                chessBoard[nextX][nextY] = Integer.MIN_VALUE;
            }
        }
        return false;
    }

    private boolean isValid(int x, int y) {
        // check if x and y don't exist outside the grid
        if(x < 0 || x >= size)
            return false;
        if( y < 0 || y >= size)
            return false;
        // invalid if we have already visited the box
        if(chessBoard[x][y] != Integer.MIN_VALUE)
            return false;

        return true;
    }

    private void showSolution() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(chessBoard[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
