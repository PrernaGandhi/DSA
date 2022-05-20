package com.dsa.interview.questions.dutch_national_array_problem;

public class NationalArrayProblem {
    // The problem is that we want to sort a T[] one-dimensional array of
    // integers in O(N) running time - and without any extra memory.
    // The array can contain values: 0, 1 and 2

    private int[] arr;

    public NationalArrayProblem(int[] arr) {
        this.arr = arr;
    }

    public void solve() {
        int i = 0;
        int j = 0;
        int k = arr.length - 1;

        while (j <= k) {
            if (arr[j] < 1) {
                swap(i, j);
                i++;
                j++;
            } else if (arr[j] == 1) {
                j++;
            } else {
                swap(j, k);
                k--;
            }
        }
        showResults();
    }

    private void showResults() {
        for (Integer val : arr) {
            System.out.print(val + " ");
        }
    }

    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
