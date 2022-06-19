package intermediate.check_if_array_is_sorted;

public class Runner {
    public static void main(String[] args) {
        CheckIfArrayIsSorted checkIfArrayIsSorted = new CheckIfArrayIsSorted();
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(checkIfArrayIsSorted.isSorted(array, 0, array.length - 1));
        array = new int[]{2, 3, 4, 1, 5};
        System.out.println(checkIfArrayIsSorted.isSorted(array, 0, array.length - 1));
    }
}
