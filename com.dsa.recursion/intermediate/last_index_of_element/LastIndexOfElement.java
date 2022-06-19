package intermediate.last_index_of_element;

public class LastIndexOfElement {
    public int find(int[] array, int current, int searchElement) {
        if (current == array.length) {
            return -1;
        }
        int result = find(array, current + 1, searchElement);
        if (array[current] == searchElement) {
            return current;
        }
        return result;
    }
}
