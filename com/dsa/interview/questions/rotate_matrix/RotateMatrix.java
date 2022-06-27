package com.dsa.interview.questions.rotate_matrix;

/*

        Rotate Matrix by 90 degrees clockwise

            Input               |           Output
      --------------------------|-------------------------
        [                       |       [
            [1, 2],             |           [3, 1],
            [3, 4]              |           [4, 2]
        ]                       |       ]
      --------------------------|-------------------------
        [                       |       [
            [1, 2, 3],          |           [7, 4, 1],
            [4, 5, 6],          |           [8, 5, 2],
            [7, 8, 9]           |           [9, 6, 3]
        ]                       |       ]
      --------------------------|--------------------------
        [                       |       [
            [5, 1, 9, 11],      |           [15, 13, 2, 5],
            [2, 4, 8, 10],      |           [14, 3, 4, 1],
            [13, 3, 6, 7],      |           [12, 6, 8, 9],
            [15, 14, 12, 16]    |           [16, 7, 10, 11]
        ]                       |       ]

        Approach :
            1.  Take transpose
            2.  Reverse each row
 */
public class RotateMatrix {

    public int[][] rotate(int[][] arr) {
        // take transpose
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr.length; col++) {
                // we need this condition,
                // otherwise what is happening is that,
                // first it gets swapped,
                // and then re-swapped to original value
                // eg, when we are at 0,2 , we swap
                // which is correct,
                // but when we reach 2,0 , we swap
                // again back to the original position
                if (row < col)
                    swap(arr, row, col, col, row);
            }
        }

        // reverse each row
        for (int row = 0; row < arr.length; row++) {
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                swap(arr, row, start, row, end);
                start++;
                end--;
            }
        }
        return arr;
    }

    private void swap(int[][] arr, int row1, int col1, int row2, int col2) {
        int temp = arr[row1][col1];
        arr[row1][col1] = arr[row2][col2];
        arr[row2][col2] = temp;
    }
}
