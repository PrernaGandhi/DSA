package soduko;

public class Soduko {
    private final int [][] sodukoBoard;
    private final int BOARD_SIZE = 9;
    private final int BOX_SIZE = 3;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;


    public Soduko(int[][] sudokuBoard) {
        this.sodukoBoard = sudokuBoard;
    }

    public void solve() {
        if(solution(0, 0)) {
            showSolution();
        } else {
            System.out.println("There is no valid solution ..........");
        }
    }

    private boolean solution(int rowIndex, int colIndex) {
        // check base-cases
        // we will consider all elements in the first column and then move to the next column
        if(rowIndex == BOARD_SIZE) {
            colIndex++;
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

            for(int num = MIN_NUMBER; num <= MAX_NUMBER; num++) {
                if(isValid(rowIndex, colIndex, num)) {

                    sodukoBoard[rowIndex][colIndex] = num;

                    if(solution(rowIndex + 1, colIndex)) {
                        return true;
                    }

                    // backtrack
                    sodukoBoard[rowIndex][colIndex] = 0;
                }
            }
        return false;
    }

    private boolean isValid(int rowIndex, int colIndex, int num) {

        // if number is already present in the given column, we return false
        for(int i = 0; i < BOARD_SIZE; i++) {
            if(sodukoBoard[i][colIndex] == num) {
                return false;
            }
        }

        // if number is already present in the given row, we return false
        for(int j = 0; j < BOARD_SIZE; j++) {
            if(sodukoBoard[rowIndex][j] == num) {
                return false;
            }
        }

        // calculate starting index of box
        int rowOffset = (rowIndex / 3 ) * BOX_SIZE;
        int colOffset = (colIndex / 3 ) * BOX_SIZE;

        // if given integer is already present in the given box then we return false
        for(int i=0;i<BOX_SIZE;i++){
            for(int j=0;j<BOX_SIZE;j++) {
                if(sodukoBoard[rowOffset + i][colOffset + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public void showSolution() {
        for(int i = 0; i < BOARD_SIZE; i++) {
            if(i % 3 == 0) System.out.println();
            for(int j = 0; j < BOARD_SIZE; j++) {
                if(j % 3 == 0) System.out.print("\t");
                System.out.print(sodukoBoard[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
