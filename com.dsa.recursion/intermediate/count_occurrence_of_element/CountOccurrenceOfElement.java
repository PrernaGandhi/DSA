package intermediate.count_occurrence_of_element;

public class CountOccurrenceOfElement {
    public int count(int[] array, int currentIndex, int searchElement) {
        if (currentIndex == -1) {
            return -1;
        }

        int result = count(array, currentIndex - 1, searchElement);

        if (array[currentIndex] == searchElement) {
            return 1 + result;
        }
        return result;
    }

}
