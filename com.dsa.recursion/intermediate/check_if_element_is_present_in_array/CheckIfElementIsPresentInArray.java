package intermediate.check_if_element_is_present_in_array;

public class CheckIfElementIsPresentInArray {
    public boolean isElementPresent(int[] array, int currentIndex, int searchElement) {
        if (currentIndex == -1) {
            return false;
        }

        boolean isElementPresent = isElementPresent(array, currentIndex - 1, searchElement);
        if (isElementPresent) {
            return true;
        }

        if (array[currentIndex] == searchElement) {
            return true;
        } else {
            return false;
        }

    }
}
