package n_queens;

public class NQueens {
    // We need to place N queens in an N*N chessboard,
    // such that no two queens can attack each other
    // O(N!) complexity
    // after placing 1 queen of N queens, you have n-1 options,
    // after placing 2 queens, you have n - 2 options,
    // n(n - 1)(n -2)(n - 3) ....
    // hence the complexity O(N!)
    // when set queens is called for the first time,
    // there will be no loops executed, so time complexity, would be constant,
    // for the second time, the loop would be executed till 1 so complexity is
    // 1 * 1
    // third
    // 1 * 2
    // fourth
    // 1 * 2 * 3
    // n
    // 1 * 2 * 3 * .... * (n - 1) * n
    private final int[][] chessBoard;
    private final int numOfQueens;

    NQueens(int numOfQueens) {
        this.chessBoard = new int[numOfQueens][numOfQueens];
        this.numOfQueens = numOfQueens;
    }

    void solve() {
        // start checking from column 0
        if(setQueens(0)) {
           printQueens();
        } else {
            System.out.println("There are no possible solution for placing " + numOfQueens
                    + " queens in " + numOfQueens + " * " + numOfQueens + " chess-board");
        }
    }

    private boolean setQueens(int colIndex) {
        // if we reached the last column of the chess board it means, we have solved the problem
        if(colIndex == numOfQueens) {
            return true;
        }

        // for each column, we iterate through all the possible positions,
        // or row indices before we find a valid place
        for(int rowIndex = 0; rowIndex < numOfQueens; rowIndex++) {

            // if the place is valid, we place the queen there
            // by updating it's value to 1
            if(isPlaceValid(rowIndex, colIndex)) {
                chessBoard[rowIndex][colIndex] = 1;

                // then we solve problem for the next column
                if(setQueens(colIndex + 1)) {
                    return true;
                }

                // if we don't find a valid place for the next queen we need to back track
                // BACKTRACK!!!
                chessBoard[rowIndex][colIndex] = 0;
            }
        }
        // if there is no valid location
        return false;
    }

    private boolean isPlaceValid(int rowIndex, int colIndex) {
        // check if there is already a queen in the same row
        // for each of the previous columns
        // check for same row index in different columns
        // - - - -
        // - - - -
        // - - - -
        // * * * A
        // row remains same, column decreases
        for (int i = 0; i < colIndex; i++)
            if(chessBoard[rowIndex][i] == 1)
                return false;


        // check diagonal locations top left
        // * - - - - - -
        // - * - - - - -
        // - - * - - - -
        // - - - A - - -
        // - - - - - - -
        // - - - - - - -
        // - - - - - - -
        // check for A
        // decrease row, decrease column
        for(int i = rowIndex, j = colIndex; i >= 0 && j >= 0; i--, j--)
            if(chessBoard[i][j] == 1)
                return false;

        // check diagonal locations from bottom left
        // - - - - - - -
        // - - - - - - -
        // - - - - - - -
        // - - - A - - -
        // - - * - - - -
        // - * - - - - -
        // * - - - - - -
        // check for A
        // increase row, decrease column
        for(int i = rowIndex, j = colIndex; i < chessBoard.length && j >= 0;i++,j--)
            if(chessBoard[i][j] == 1)
                return false;

        // if no collisions
        return true;
    }

    private void printQueens() {
        // 1 represents there is a queen
        // 0 represents the location is empty
        for (int[] row : chessBoard) {
            for (int element : row) {
                if (element == 1) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
}
