package com.dsa.interview.questions.search_in_matrix;

public class Runner {
    public static void main(String[] args) {
        int [][] arr = {
                {2, 6, 7, 11},
                {3, 8, 10, 12},
                {4, 9, 11, 13},
                {5, 15, 16,18}
        };

        SearchInMatrix searchInMatrix = new SearchInMatrix();
        System.out.println(searchInMatrix.isElementPresent(arr, 11));
        System.out.println(searchInMatrix.isElementPresent(arr, 9));
        System.out.println(searchInMatrix.isElementPresent(arr, 5));
        System.out.println(searchInMatrix.isElementPresent(arr, 18));
        System.out.println(searchInMatrix.isElementPresent(arr, 51));
    }
}
