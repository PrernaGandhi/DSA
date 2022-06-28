package com.dsa.interview.questions.set_matrix_zeroes;

/*
                Input                   |           Output
     -----------------------------------|------------------------------
            0   4   1   0               |       0   0   0   0
            3   2   1   5               |       0   0   1   0
            4   0   7   2               |       0   0   0   0
     -----------------------------------|------------------------------
                1   0   1               |       0   0   0
                1   1   1               |       1   0   1
                1   1   1               |       1   0   1
      ----------------------------------|------------------------------
                    0   1               |           0   0
                    1   1               |           0   1
      ----------------------------------|------------------------------
                1   1   1               |           1   0   1
                1   0   1               |           0   0   0
                1   1   1               |           1   0   1


       Naive Approach :
       Store row and column in set and then re-iterate the matrix and set zeroes
       for that entire row and column

            Time complexity : O(M*N)
            Space complexity : O(M+N)

      Efficient Approach :
      we make use of two variables,
        1.  isZeroInFirstRow
        2.  isZeroInFirstColumn

        Iterate the matrix,
        if i,j equals 0,
        then make i,0 and 0,j also zero,
        i.e, making the element in the
        first row and first column 0
            Time complexity : O(M*N)
            Space complexity : O(1)

 */
public class SetMatrixZeroes {
    public int[][] setZeroes(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        boolean isZeroInFirstRow = false;
        boolean isZeroInFirstColumn = false;

        // does first row have 0 element
        for (int i = 0; i < n; i++) {
            if (arr[0][i] == 0) {
                isZeroInFirstRow = true;
                break;
            }
        }
        // does first column have 0 element
        for (int i = 0; i < m; i++) {
            if (arr[i][0] == 0) {
                isZeroInFirstColumn = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // making first row and column 0
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        // if there are zeroes in first row
        if (isZeroInFirstRow) {
            for (int i = 0; i < m; i++) {
                arr[0][i] = 0;
            }
        }
        // if there are zeroes in first column
        if (isZeroInFirstColumn) {
            for (int i = 0; i < m; i++) {
                arr[i][0] = 0;
            }
        }
        return arr;
    }
}