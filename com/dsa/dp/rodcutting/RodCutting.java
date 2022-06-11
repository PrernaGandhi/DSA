package com.dsa.dp.rodcutting;

/*
    We have a rod of length L, we need to cut the rod into pieces and sell it
    and maximize the profit. Each rod of length K is associated with a price

       Rod Length   |       Price
  ------------------|--------------------
            0       |       0
            1       |       2
            2       |       5
            3       |       7
            4       |       3
            5       |       9

        Rod length - 5

                           <---------- Rod Length ---------->
                |   0   |   1   |   2   |   3   |   4   |   5   |
       ---------|-------|-------|-------|-------|-------|-------|---
    ^       0   |   0   |   0   |   0   |   0   |   0   |   0   |
    |       1   |   0   |   2   |   4   |   6   |   8   |   10  |
   size     2   |   0   |   2   |   5   |   7   |   10  |   12  |
    of      3   |   0   |   2   |   5   |   7   |   10  |   12  |
  piece     4   |   0   |   2   |   5   |   7   |   10  |   12  |
    |       5   |   0   |   2   |   5   |   7   |   10  |   12  |
    v           |       |       |       |       |       |       |

    Size of |  Rod  |                                   |                                   |
    Piece   | Length|          Taking the piece         |       Not taking the piece        |   Max Profit
   ---------|-------|-----------------------------------|-----------------------------------|---------------
        0   |   0   |               0                   |                   0               |       0
        1   |   0   |         can't fit item            |            F(1-1,0) = 0           |       0
        2   |   0   |         can't fit item            |            F(2-1,0) = 0           |       0
        3   |   0   |         can't fit item            |            F(3-1,0) = 0           |       0
        4   |   0   |         can't fit item            |            F(4-1,0) = 0           |       0
        5   |   0   |         can't fit item            |            F(5-1,0) = 0           |       0

    Size of |  Rod  |                                   |                                   |
    Piece   | Length|          Taking the piece         |       Not taking the piece        |   Max Profit
   ---------|-------|-----------------------------------|-----------------------------------|---------------
        0   |   1   |               0                   |                   0               |       0
        1   |   1   |            P[1] = 2               |            F(1-1,1) = 0           |       2
        2   |   1   |         can't fit item            |            F(2-1,1) = 2           |       2
        3   |   1   |         can't fit item            |            F(3-1,1) = 2           |       2
        4   |   1   |         can't fit item            |            F(4-1,1) = 2           |       2
        5   |   1   |         can't fit item            |            F(5-1,1) = 2           |       2

    Size of |  Rod  |                                   |                                   |
    Piece   | Length|          Taking the piece         |       Not taking the piece        |   Max Profit
   ---------|-------|-----------------------------------|-----------------------------------|---------------
        0   |   2   |               0                   |                   0               |       0
        1   |   2   |     P[1] + F(1,2-1) = 2 + 2  = 4  |            F(1-1,2) = 0           |       4
        2   |   2   |            P[2] = 5               |            F(2-1,2) = 4           |       5
        3   |   2   |         can't fit item            |            F(3-1,2) = 5           |       5
        4   |   2   |         can't fit item            |            F(4-1,2) = 5           |       5
        5   |   2   |         can't fit item            |            F(5-1,2) = 5           |       5

    Size of |  Rod  |                                   |                                   |
    Piece   | Length|          Taking the piece         |       Not taking the piece        |   Max Profit
   ---------|-------|-----------------------------------|-----------------------------------|---------------
        0   |   3   |               0                   |                   0               |       0
        1   |   3   |    P[1] + F(1,3-1) = 2 + 4 = 6    |            F(1-1,3) = 0           |       6
        2   |   3   |   P[2] + F(2,3-2) = 5 + 2 = 7     |            F(2-1,3) = 6           |       7
        3   |   3   |            P[3] = 7               |            F(3-1,3) = 7           |       7
        4   |   3   |         can't fit item            |            F(4-1,3) = 7           |       7
        5   |   3   |         can't fit item            |            F(5-1,3) = 7           |       7

    Size of |  Rod  |                                   |                                   |
    Piece   | Length|          Taking the piece         |       Not taking the piece        |   Max Profit
   ---------|-------|-----------------------------------|-----------------------------------|---------------
        0   |   4   |               0                   |                   0               |       0
        1   |   4   |    P[1] + F(1,4-1) = 2 + 6 = 8    |            F(1-1,4) = 0           |       8
        2   |   4   |   P[2] + F(2,4-2) = 5 + 5 = 10    |            F(2-1,4) = 8           |       10
        3   |   4   |   P[3] + F(3,4-3) = 7 + 2 = 9     |            F(3-1,4) = 10          |       10
        4   |   4   |            P[4] = 3               |            F(4-1,4) = 10          |       10
        5   |   4   |         can't fit item            |            F(5-1,4) = 10          |       10

    Size of |  Rod  |                                   |                                   |
    Piece   | Length|          Taking the piece         |       Not taking the piece        |   Max Profit
   ---------|-------|-----------------------------------|-----------------------------------|---------------
        0   |   5   |               0                   |                   0               |       0
        1   |   5   |   P[1] + F(1,5-1) = 2 + 8 = 10    |            F(1-1,5) = 0           |       10
        2   |   5   |   P[2] + F(2,5-2) = 5 + 7 = 12    |            F(2-1,5) = 10          |       12
        3   |   5   |   P[3] + F(3,5-3) = 7 + 5 = 12    |            F(3-1,5) = 12          |       12
        4   |   5   |   P[4] + F(4,5-4) = 3 + 2 = 5     |            F(4-1,5) = 12          |       12
        5   |   5   |            P[5] = 9               |            F(5-1,5) = 12          |       12

    Max profit ::: $12
 */
public class RodCutting {
    private int rodLength;

    private int[][] dpTable;

    private int[] price;

    public RodCutting(int[] price, int rodLength) {
        this.rodLength = rodLength;
        this.dpTable = new int[this.rodLength + 1][this.rodLength + 1];
        this.price = price;
    }

    public int solution() {
        for (int sizeOfPiece = 1; sizeOfPiece <= rodLength; sizeOfPiece++) {
            int profitAfterIncludingTheItem = 0;
            int profitAfterExcludingTheItem = 0;
            // for a given piece
            for (int currentRodLength = 1; currentRodLength <= rodLength; currentRodLength++) {
                if (sizeOfPiece <= currentRodLength) {
                    // including the item
                    // include the price of the item
                    // then for the remaining,
                    // take the value from the previous row
                    // for the size left to complete rod length from above
                    profitAfterIncludingTheItem = price[sizeOfPiece] +
                            // this case we want to find with the size of piece and the
                            // length left to complete the rod length
                            dpTable[sizeOfPiece][currentRodLength - sizeOfPiece];
                }
                // whether we can include the given piece or not,
                // it is important to check whether it is more
                // beneficial to include the item or exclude it
                profitAfterExcludingTheItem = dpTable[sizeOfPiece - 1][currentRodLength];

                dpTable[sizeOfPiece][currentRodLength] = Math.max(profitAfterExcludingTheItem, profitAfterIncludingTheItem);
            }
        }
        return dpTable[rodLength][rodLength];
    }

    public void showSolution() {
        System.out.println("Optimal Profit : $ " + dpTable[price.length - 1][rodLength]);

        for (int rowIndex = price.length - 1, colIndex = rodLength; rowIndex > 0; ) {
            if (dpTable[rowIndex][colIndex] != 0 && dpTable[rowIndex][colIndex] != dpTable[rowIndex - 1][colIndex]) {
                System.out.println("We use piece " + rowIndex + ".");
                colIndex = colIndex - rowIndex;
            } else {
                rowIndex--;
            }
        }
    }

    public int solveRecursive(int currentRodLength, int sizeOfPiece) {
        if (currentRodLength == 0 || sizeOfPiece == 0) {
            return 0;
        }
        int profitAfterIncludingThePiece = 0;
        int profitAfterExcludingThePiece = 0;
        // include the piece if possible
        if (sizeOfPiece <= currentRodLength)
            profitAfterIncludingThePiece = price[sizeOfPiece] + solveRecursive(currentRodLength - sizeOfPiece, sizeOfPiece - 1);
        // whether we include the piece or not,
        // it is important to check whether it is
        // more beneficial to include the piece or exclude it
        profitAfterExcludingThePiece = solveRecursive(currentRodLength, sizeOfPiece - 1);
        int result = Math.max(profitAfterIncludingThePiece, profitAfterExcludingThePiece);
        return result;
    }
}
