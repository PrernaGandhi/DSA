package intermediate.check_if_element_is_present_in_array;

public class Runner {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        CheckIfElementIsPresentInArray checkIfElementIsPresentInArray = new CheckIfElementIsPresentInArray();
        System.out.println(checkIfElementIsPresentInArray.isElementPresent(array, array.length - 1, 5));
        System.out.println(checkIfElementIsPresentInArray.isElementPresent(array, array.length - 1, 10));
    }
}
