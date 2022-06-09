package knights_tour_problem;

/*
    The Knights Tour problem is :
    starting from a given chess board of size N*N,
    we need to step on every position of the chess board

    There is no valid solution for 4*4 matrix

    Let's check for 5 * 5 matrix:

    lets start by stepping on the 1 st position

    Possible moves:
    xMoves = [2, 1, -1, -2, -2, -1, 1, 2]
    yMoves = [1, 2, 2, 1, -1, -2, -2, -1]

    xMoves       yMoves                 Description                       Moves
      2            1            two steps forward, one step up                ____|
                                                                          |
      1            2            one step forward, two steps up          __|
                                                                              |
     -1            2            one step back, two steps up                   |__

     -2            1            two steps backward, one step up     |____

     -2           -1            two steps back, one step down                 ____
                                                                          __ |
     -1           -2            one move back, two moves down            |
                                                                         |     __
      1           -2            one step forward, two moves down                 |
                                                                                 |
      2           -1            two steps forward, one move down          ____
                                                                              |

        0   -   -   -   -
        -   -   -   -   -
        -   -   -   -   -
        -   -   -   -   -
        -   -   -   -   -

 --->  Now we have two move   |     or  ____
                              |__           |

       lets take the first move,    |
                                    |__

       now our chess board looks like
        0   -   -   -   -
        -   -   -   -   -
        -   1   -   -   -
        -   -   -   -   -
        -   -   -   -   -                                          __
                                |                                 |         __
 --->  Now we have ____|   or __| or |   or |____   or _____   or |    or     |   or ____
                                     |__              |                       |          |

       let's take the first move  ____|


       now chess board looks like
        0   -   -   -   -
        -   -   -   2   -
        -   1   -   -   -
        -   -   -   -   -
        -   -   -   -   -

        take   |
               |__

        0   -   -   -   -
        -   -   -   2   -
        -   1   -   -   -
        -   -   -   -   3
        -   -   -   -   -
               ____
        take       |
        0   -   -   -   -
        -   -   -   2   -
        -   1   4   -   -
        -   -   -   -   3
        -   -   -   -   -

        take ____|
        0   -   -   -   -
        -   -   -   2   5
        -   1   4   -   -
        -   -   -   -   3
        -   -   -   -   -

        take |____
        0   -   6   -   -
        -   -   -   2   5
        -   1   4   -   -
        -   -   -   -   3
        -   -   -   -   -

        take  ____
             |
        0   -   6   -   -
        7   -   -   2   5
        -   1   4   -   -
        -   -   -   -   3
        -   -   -   -   -
             __
        take   |
               |
        0   -   6   -   -
        7   -   -   2   5
        -   1   4   -   -
        -   8   -   -   3
        -   -   -   -   -


        take ____|

        0   -   6   -   -
        7   -   -   2   5
        -   1   4   9   -
        -   8   -   -   3
        -   -   -   -   -
               |
        take __|

        0   -   6   -   10
        7   -   -   2   5
        -   1   4   9   -
        -   8   -   -   3
        -   -   -   -   -

              ____
        take |

        0   -   6   -   10
        7   -   11   2   5
        -   1   4   9   -
        -   8   -   -   3
        -   -   -   -   -

              ____
        take |

        0   -   6   -   10
        7   -   11   2   5
        12   1   4   9   -
        -   8   -   -   3
        -   -   -   -   -

                |
        take  __|

        0   13   6   -   10
        7   -   11   2   5
        12   1   4   9   -
        -   8   -   -   3
        -   -   -   -   -
                                    __
        no more moves, back track     |
                                      |
        0   -   6   -   10
        7   -   11   2   5
        12   1   4   9   -
        -   8   -   -   3
        -   13   -   -   -

       take ____|

        0   -   6   -   10
        7   -   11   2   5
        12   1   4   9   -
        -   8   -   14   3
        -   13   -   -   -

        no more moves, backtrack
        0   -   6   -   10
        7   -   11   2   5
        12   1   4   9   -
        -   8   -   -   3
        -   13   -   -   -
                                ____
        no more moves backtrack,    |

        0   -   6   -   10
        7   -   11   2   5
        12   1   4   9   -
        -   8   13   -   3
        -   -   -   -   -

        take ____|
        0   -   6   -   10
        7   -   11   2   5
        12   1   4   9  14
        -   8   13   -   3
        -   -   -   -   -
              |
        take  |__
        0   -   6   15   10
        7   -   11   2   5
        12   1   4   9  14
        -   8   13   -   3
        -   -   -   -   -
                 ____
        take    |

        0   -   6   15   10
        7   16   11   2   5
        12   1   4   9  14
        -   8   13   -   3
        -   -   -   -   -

       take    |
             __|

        0   -   6   15   10
        7   16   11   2   5
        12   1   4   9   14
        17   8   13   -   3
        -   -   -   -   -

        take |____
         0   -   6   15   10
        7   16   11   2   5
        12   1   4   9   14
        17   8   13   -   3
        -   -   18   -   -


       no more moves, backtrack

        0   -   6   15   10
        7   16   11   2   5
        12   1   4   9   14
        17   8   13   -   3
        -   -   -   -   -

        no more moves, backtrack ....


        final solution :
            0	5	14	9	20
            13	8	19	4	15
            18	1	6	21	10
            7	12	23	16	3
            24	17	2	11	22


 */
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
        // we start from the top left corner as step 1
        // if we are able to step on each of the position of the chess board,
        // we have found the solution
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

        // iterating to get the possible moves
        for (int i = 0; i < xMoves.length; i++) {
            int nextX = x + xMoves[i];
            int nextY = y + yMoves[i];
            if (isValid(nextX, nextY)) {
                // update the chessboard if x and y co-ordinates are valid
                chessBoard[nextX][nextY] = stepCount;

                // find the solution to the next position
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
        // check if x doesn't hop outside the grid
        if (x < 0 || x >= size)
            return false;
        // check if y doesn't hop outside the grid
        if (y < 0 || y >= size)
            return false;
        // invalid if we have already visited the box
        if (chessBoard[x][y] != Integer.MIN_VALUE)
            return false;

        return true;
    }

    private void showSolution() {
        for (int rowIndex = 0; rowIndex < size; rowIndex++) {
            for (int columnIndex = 0; columnIndex < size; columnIndex++) {
                System.out.print(chessBoard[rowIndex][columnIndex] + "\t");
            }
            System.out.println();
        }
    }
}
