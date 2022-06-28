package com.dsa.interview.questions.spiral_order_matrix;

/*
        We need to traverse the matrix in spiral order

            Input       |           Output
     -------------------|--------------------------------
        1   2   3       |
        4   5   6       |   1 2 3 6 9 8 7 4 5
        7   8   9       |
     -------------------|---------------------------------
        1   2   3   4   |
        5   6   7   8   |   1 2 3 4 8 12 11 10 9 5 6 7
        9   10  11  12  |
      ------------------|---------------------------------


      Approach : we need 4 pointers, startRow, startColumn, endRow, endColumn

      sr, sc                er
       _____________________
      |    _____________    |
      |   |             |   |
      |   |             |   |
      |   |             |   |
      |   |             |   |
      |   |_____________|   |
      |_____________________|
     ec


     we need to print the start row, then start column,
     then end row then end column,

     then sr++
          sc++
          er--
          ec--

 */
public class SpiralOrderMatrix {

    public int[] traverse(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int startRow = 0;
        int startColumn = 0;
        int endRow = m - 1;
        int endColumn = n - 1;
        int[] result = new int[m * n];

        int count = 0;
        int currIndex = 0;
        while (startRow <= endRow && startColumn <= endColumn) {
            // print start row
            // to print start row we iterate
            // the start and end column keeping
            // the start row constant
            for (int i = startColumn; i <= endColumn; i++) {
                result[currIndex] = arr[startRow][i];
                currIndex++;
                count++;
            }
            startRow++;
            if (count == m * n) return result;
            // print end column
            // keeping end column constant,
            // iterate between start row and end row
            for (int i = startRow; i <= endRow; i++) {
                result[currIndex] = arr[i][endColumn];
                currIndex++;
                count++;
            }
            endColumn--;
            if (count == m * n) return result;

            // print end row
            // reverse print, between end column and start column
            for (int i = endColumn; i >= startColumn; i--) {
                result[currIndex] = arr[endRow][i];
                currIndex++;
                count++;
            }
            endRow--;
            if (count == m * n) return result;

            // print start column
            // iterate between end row and start row
            for (int i = endRow; i >= startRow; i--) {
                result[currIndex] = arr[i][startColumn];
                currIndex++;
                count++;
            }
            startColumn++;
            if (count == m * n) return result;
        }
        return result;
    }
}
