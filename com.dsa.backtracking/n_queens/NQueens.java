package n_queens;

/*
    We need to place N queens in an N*N matrix such that no two queens threaten each other
    There is no solution available for 3*3 matrix

    Let's try to place 4 queens in a 4*4 matrix
    Step 1: We place the first queen in the top left corner
     ___ ___ ___ ___
    | Q |   |   |   |
     ___ ___ ___ ___
    |   |   |   |   |
     ___ ___ ___ ___
    |   |   |   |   |
     ___ ___ ___ ___
    |   |   |   |   |
     --- --- --- ---
    Step 2: Next we try to place the next queen in the second column
     ___ ___ ___ ___
    | Q | X |   |   |
     ___ ___ ___ ___
    |   | X |   |   |
     ___ ___ ___ ___
    |   | Q |   |   |
     ___ ___ ___ ___
    |   |   |   |   |
     --- --- --- ---
    Step 3: place the next queen in 3 rd column
     ___ ___ ___ ___
    | Q | X | X |   |
     ___ ___ ___ ___
    |   | X | X |   |
     ___ ___ ___ ___
    |   | Q | X |   |
     ___ ___ ___ ___
    |   |   | X |   |
     --- --- --- ---
    Step 4: since there is no position for the 3rd queen in the third column,
            we back track and try to find some other position for the previous queen
     ___ ___ ___ ___
    | Q | X |   |   |
     ___ ___ ___ ___
    |   | X |   |   |
     ___ ___ ___ ___
    |   | X |   |   |
     ___ ___ ___ ___
    |   | Q |   |   |
     --- --- --- ---
    Step 5: Since we found the position to place the previous queen, we now find the
            position for the next queen
     ___ ___ ___ ___
    | Q | X | X |   |
     ___ ___ ___ ___
    |   | X | Q |   |
     ___ ___ ___ ___
    |   | X |   |   |
     ___ ___ ___ ___
    |   | Q |   |   |
     --- --- --- ---
    Step 6: Since we found the position for the 3 rd queen we move to the next column
     ___ ___ ___ ___
    | Q | X | X | X |
     ___ ___ ___ ___
    |   | X | Q | X |
     ___ ___ ___ ___
    |   | X |   | X |
     ___ ___ ___ ___
    |   | Q |   | X |
     --- --- --- ---
    Step 7: Since there is no valid position for the 4th queen, we backtrack again
     ___ ___ ___ ___
    | Q | X | X |   |
     ___ ___ ___ ___
    |   | X | X |   |
     ___ ___ ___ ___
    |   | X | X |   |
     ___ ___ ___ ___
    |   | Q | X |   |
     --- --- --- ---
    Step 8: Since there still isn't any valid position for the third queen we back track again
     ___ ___ ___ ___
    | Q | X |   |   |
     ___ ___ ___ ___
    |   | X |   |   |
     ___ ___ ___ ___
    |   | X |   |   |
     ___ ___ ___ ___
    |   | X |   |   |
     --- --- --- ---
    Step 9: Since there is no valid position for 2nd queen we backtrack and try to re position
            the 1st queen
     ___ ___ ___ ___
    | X |   |   |   |
     ___ ___ ___ ___
    | Q |   |   |   |
     ___ ___ ___ ___
    |   |   |   |   |
     ___ ___ ___ ___
    |   |   |   |   |
     --- --- --- ---
    Step 10: Now we position the 2nd queen again
     ___ ___ ___ ___
    | X | X |   |   |
     ___ ___ ___ ___
    | Q | X |   |   |
     ___ ___ ___ ___
    |   | X |   |   |
     ___ ___ ___ ___
    |   | Q |   |   |
     --- --- --- ---
    Step 11: Now we position the third queen
     ___ ___ ___ ___
    | X | X | Q |   |
     ___ ___ ___ ___
    | Q | X |   |   |
     ___ ___ ___ ___
    |   | X |   |   |
     ___ ___ ___ ___
    |   | Q |   |   |
     --- --- --- ---
    Step 12: Now we position the last queen
     ___ ___ ___ ___
    | X | X | Q | X |
     ___ ___ ___ ___
    | Q | X |   | X |
     ___ ___ ___ ___
    |   | X |   | Q |
     ___ ___ ___ ___
    |   | Q |   |   |
     --- --- --- ---

    Backtracking helps us remove the bad states, hence is better than bruteforce approach
 */
public class NQueens {
    // Bruteforce approach takes O(N)
    // backtracking reduces time complexity to exponential time
    private final int[][] chessBoard;
    private final int numOfQueens;

    NQueens(int numOfQueens) {
        this.chessBoard = new int[numOfQueens][numOfQueens];
        this.numOfQueens = numOfQueens;
    }

    void solve() {
        // start checking from column 0
        // we are able to find a valid solution starting from the 0 column,
        // then we print the queens
        if (setQueens(0)) {
            printQueens();
        } else {
            System.out.println("There are no possible solution for placing " + numOfQueens
                    + " queens in " + numOfQueens + " * " + numOfQueens + " chess-board");
        }
    }

    private boolean setQueens(int colIndex) {
        // if we reached the last column of the chess board it means,
        // we have solved the problem
        if (colIndex == numOfQueens) {
            return true;
        }

        // for each column, we iterate through all the possible positions,
        // or row indices before we find a valid place
        for (int rowIndex = 0; rowIndex < numOfQueens; rowIndex++) {

            // if the place is valid, we place the queen there
            // by updating it's value to 1
            if (isPlaceValid(rowIndex, colIndex)) {
                chessBoard[rowIndex][colIndex] = 1;

                // then we try to solve problem for the next column
                if (setQueens(colIndex + 1)) {
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
            if (chessBoard[rowIndex][i] == 1)
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
        for (int i = rowIndex, j = colIndex; i >= 0 && j >= 0; i--, j--)
            if (chessBoard[i][j] == 1)
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
        for (int i = rowIndex, j = colIndex; i < chessBoard.length && j >= 0; i++, j--)
            if (chessBoard[i][j] == 1)
                return false;

        // if no collisions, then the position is valid for the queen
        return true;
    }

    private void printQueens() {
        // 1 represents there is a queen
        // 0 represents the location is empty
        for (int[] row : chessBoard) {
            for (int element : row) {
                if (element == 1) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
}
