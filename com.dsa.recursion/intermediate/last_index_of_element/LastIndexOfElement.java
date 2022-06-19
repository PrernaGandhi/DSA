package intermediate.last_index_of_element;

public class LastIndexOfElement {
    public int find(int[] array, int current, int searchElement) {
        if (current == -1) {
            return -1;
        }
        if (array[current] == searchElement) {
            return current;
        }
        int result = find(array, current - 1, searchElement);
        return result;
    }
}
