package com.dsa.interview.questions.count_occurrences_of_element;

public class Runner {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        CountOccurrencesOfElement countOccurrencesOfElement = new CountOccurrencesOfElement();
        System.out.println(countOccurrencesOfElement.count(arr, 5));
        arr = new int[]{1, 3, 5, 5, 5, 5, 7, 123, 125};
        System.out.println(countOccurrencesOfElement.count(arr, 7));
        arr = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(countOccurrencesOfElement.count(arr, 8));
        arr = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(countOccurrencesOfElement.count(arr, 6));
    }
}
