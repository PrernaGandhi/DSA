package intermediate.first_index_of_element;

public class FirstIndexOfElement {
    public int find(int[] array, int current, int searchElement) {
        if (current == array.length) {
            return -1;
        }
        if (array[current] == searchElement) {
            return current;
        }
        int result = find(array, current + 1, searchElement);
        return result;
    }
}
