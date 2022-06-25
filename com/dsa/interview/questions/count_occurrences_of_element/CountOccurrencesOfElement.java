package com.dsa.interview.questions.count_occurrences_of_element;

import com.dsa.interview.questions.first_and_last_occurance_of_element.FirstAndLastOccurrenceOfElement;

/*
    Count occurrences of element - get the difference of index of first index and last index
 */
public class CountOccurrencesOfElement {
    public int count(int[] arr, int target) {
        FirstAndLastOccurrenceOfElement countOccurrences = new FirstAndLastOccurrenceOfElement();
        int firstOccurrenceIndex = countOccurrences.getIndexOfFirstOccurrenceOfElement(arr, target);
        int lastOccurrenceIndex = countOccurrences.getIndexOfLastOccurrenceOfElement(arr, target);
        if (firstOccurrenceIndex == -1 || lastOccurrenceIndex == -1) {
            return 0;
        }
        return lastOccurrenceIndex - firstOccurrenceIndex + 1;
    }
}
