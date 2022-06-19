package intermediate.check_if_array_is_sorted;

public class CheckIfArrayIsSorted {
    public boolean isSorted(int[] array, int startIndex, int endIndex) {
        if (endIndex - startIndex == 1 || endIndex - startIndex == 0) {
            return true;
        }

        // sort till second last element
        boolean isSorted = isSorted(array, startIndex, endIndex - 1);

        // if unsorted, then return false
        if (!isSorted) {
            return false;
        }

        // check for the last element
        if (array[endIndex] > array[endIndex - 1])
            return true;
        else
            return false;
    }
}
