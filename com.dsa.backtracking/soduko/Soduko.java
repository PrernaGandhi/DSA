package soduko;

/*
    Soduko Board:
                 ___ ___ ___         ___ ___ ___         ___ ___ ___
                | 3 | 0 | 6 |       | 5 | 0 | 8 |       | 4 | 0 | 0 |
                 ___ ___ ___         ___ ___ ___         ___ ___ ___
                | 5 | 2 | 0 |       | 0 | 0 | 0 |       | 0 | 0 | 0 |
                 ___ ___ ___         ___ ___ ___         ___ ___ ___
                | 0 | 8 | 7 |       | 0 | 0 | 0 |       | 0 | 3 | 1 |
                 === === ===         === === ===         === === ===
                 === === ===         === === ===         === === ===
                | 0 | 0 | 3 |       | 0 | 1 | 0 |       | 0 | 8 | 0 |
                 ___ ___ ___         ___ ___ ___         ___ ___ ___
                | 9 | 0 | 0 |       | 8 | 6 | 3 |       | 0 | 0 | 5 |
                 ___ ___ ___         ___ ___ ___         ___ ___ ___
                | 0 | 5 | 0 |       | 0 | 9 | 0 |       | 6 | 0 | 0 |
                 === === ===         === === ===         === === ===
                 === === ===         === === ===         === === ===
                | 1 | 3 | 0 |       | 0 | 0 | 0 |       | 2 | 5 | 0 |
                 ___ ___ ___         ___ ___ ___         ___ ___ ___
                | 0 | 0 | 0 |       | 0 | 0 | 0 |       | 0 | 7 | 4 |
                 ___ ___ ___         ___ ___ ___         ___ ___ ___
                | 0 | 0 | 5 |       | 2 | 0 | 6 |       | 3 | 0 | 0 |
                 === === ===         === === ===         === === ===

       Steps:
       Start from 0, 0
       we go column wise
       if the value chosen is valid for the given box and the board
       choose the value in the next row for the same column


        Solution:
        	3	1	6		5	7	8		4	9	2
	        5	2	9		1	3	4		7	6	8
	        4	8	7		6	2	9		5	3	1

	        2	6	3		4	1	5		9	8	7
	        9	7	4		8	6	3		1	2	5
	        8	5	1		7	9	2		6	4	3

	        1	3	8		9	4	7		2	5	6
	        6	9	2		3	5	1		8	7	4
	        7	4	5		2	8	6		3	1	9

 */
public class Soduko {
    private final int[][] sodukoBoard;
    private final int BOARD_SIZE = 9;
    private final int BOX_SIZE = 3;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;


    public Soduko(int[][] sudokuBoard) {
        this.sodukoBoard = sudokuBoard;
    }

    public void solve() {
        // if I am able to solve it starting from the first box
        // then we show the solution
        if (solution(0, 0)) {
            showSolution();
        } else {
            System.out.println("There is no valid solution ..........");
        }
    }

    private boolean solution(int rowIndex, int colIndex) {
        // check base-cases
        // we will consider all elements in the first column and then move to the next column
        if (rowIndex == BOARD_SIZE) {
            colIndex++;
            // this means we have come to the last box of soduko
            // hence we have solved the problem
            if (colIndex == BOARD_SIZE) {
                return true;
            } else {
                // re-initialize, we have considered all rows in the the given column,
                // now start checking nex column with the row at index 0
                rowIndex = 0;
            }
        }
        // skip filled cells
        if (sodukoBoard[rowIndex][colIndex] != 0)
            return solution(rowIndex + 1, colIndex);

        for (int num = MIN_NUMBER; num <= MAX_NUMBER; num++) {
            // check if the given number is valid in the current position
            if (isValid(rowIndex, colIndex, num)) {

                // assign the value
                sodukoBoard[rowIndex][colIndex] = num;

                // check for the next row position in the same column
                if (solution(rowIndex + 1, colIndex)) {
                    return true;
                }

                // backtrack if we don't find the solution for row + 1, column
                sodukoBoard[rowIndex][colIndex] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int rowIndex, int colIndex, int num) {

        // if number is already present in the given column, we return false
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (sodukoBoard[i][colIndex] == num) {
                return false;
            }
        }

        // if number is already present in the given row, we return false
        for (int j = 0; j < BOARD_SIZE; j++) {
            if (sodukoBoard[rowIndex][j] == num) {
                return false;
            }
        }

        // calculate starting index of box
        int rowOffset = (rowIndex / 3) * BOX_SIZE;
        int colOffset = (colIndex / 3) * BOX_SIZE;

        // if given integer is already present in the given box then we return false
        for (int i = 0; i < BOX_SIZE; i++) {
            for (int j = 0; j < BOX_SIZE; j++) {
                if (sodukoBoard[rowOffset + i][colOffset + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public void showSolution() {
        for (int rowIndex = 0; rowIndex < BOARD_SIZE; rowIndex++) {
            if (rowIndex % 3 == 0)
                System.out.println();
            for (int colIndex = 0; colIndex < BOARD_SIZE; colIndex++) {
                if (colIndex % 3 == 0)
                    System.out.print("\t");
                System.out.print(sodukoBoard[rowIndex][colIndex] + "\t");
            }
            System.out.println();
        }
    }
}
