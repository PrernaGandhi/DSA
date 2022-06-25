package com.dsa.interview.questions.first_and_last_occurance_of_element;

public class Runner {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        FirstAndLastOccurrenceOfElement firstAndLastOccurrenceOfElement = new FirstAndLastOccurrenceOfElement();
        System.out.print(firstAndLastOccurrenceOfElement.getIndexOfFirstOccurrenceOfElement(arr, 5) + " ");
        System.out.println(firstAndLastOccurrenceOfElement.getIndexOfLastOccurrenceOfElement(arr, 5));
        arr = new int[]{1, 3, 5, 5, 5, 5, 7, 123, 125};
        System.out.print(firstAndLastOccurrenceOfElement.getIndexOfFirstOccurrenceOfElement(arr, 7) + " ");
        System.out.println(firstAndLastOccurrenceOfElement.getIndexOfLastOccurrenceOfElement(arr, 7));
        arr = new int[]{5, 7, 7, 8, 8, 10};
        System.out.print(firstAndLastOccurrenceOfElement.getIndexOfFirstOccurrenceOfElement(arr, 8) + " ");
        System.out.println(firstAndLastOccurrenceOfElement.getIndexOfLastOccurrenceOfElement(arr, 8));
        arr = new int[]{5, 7, 7, 8, 8, 10};
        System.out.print(firstAndLastOccurrenceOfElement.getIndexOfFirstOccurrenceOfElement(arr, 6) + " ");
        System.out.println(firstAndLastOccurrenceOfElement.getIndexOfLastOccurrenceOfElement(arr, 6));
    }
}
