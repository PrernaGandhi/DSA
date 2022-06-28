package com.dsa.interview.questions.search_in_matrix;

/*
        We need to search a given number in the matrix,
        this matrix has a special property that,
        each row is sorted and each column is sorted

            2   6   7   11
            3   8   10  12
            4   9   11  13
            5   15  16  18


        Approach 1 : Bruteforce approach
            Iterate through each element and check if
            we found the element

            Time complexity : O(M*N)
            Space complexity : O(1)


        Approach 2 : Binary Search
            Since each row is sorted,
            we go over each row and
            search using binary search

            Time complexity : O(M*logN)
            Space complexity : O(1)


        Approach 3 : Staircase method
            We start from the top right most element,
            if element is greater than the
            search element, then we move left
            if element is smaller than the
            search element, then we move down

            Time complexity : O(M + N)
            Space complexity : O(1)


 */
public class SearchInMatrix {
    public boolean isElementPresent(int[][] arr, int searchElement) {
        int m = arr.length;
        int n = arr[0].length;
        int startRow = 0;
        int startColumn = n - 1;
        while (startRow < m && startColumn >= 0) {
            if (arr[startRow][startColumn] == searchElement) {
                return true;
            }
            if (arr[startRow][startColumn] > searchElement) {
                startColumn--;
            } else if (arr[startRow][startColumn] < searchElement) {
                startRow++;
            }
        }
        return false;
    }
}

