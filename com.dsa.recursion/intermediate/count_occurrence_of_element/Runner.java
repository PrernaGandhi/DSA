package intermediate.count_occurrence_of_element;

public class Runner {
    public static void main(String[] args) {
        CountOccurrenceOfElement countOccurrenceOfElement = new CountOccurrenceOfElement();
        int[] array = {1, 2, 3, 5, 4, 5, 5};
        System.out.println(countOccurrenceOfElement.count(array, array.length - 1, 5));
        System.out.println(countOccurrenceOfElement.count(array, array.length - 1, 2));
        System.out.println(countOccurrenceOfElement.count(array, array.length - 1, 10));

    }
}
