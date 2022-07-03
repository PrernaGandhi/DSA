package com.dsa.interview.questions.k_smallest_elements;

public class Runner {
    public static void main(String[] args) {
        int[] arr = {8, 5, 12, 10, 0, 1, 6, 9};
        KthSmallestElements kthSmallestElements = new KthSmallestElements();
        kthSmallestElements.findKSmallestElements(arr, 4);
    }
}
