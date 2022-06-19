package intermediate.sum_of_array;

public class SumOfArray {
    public int calculate(int[] arr, int index) {
        if (index == -1) {
            return 0;
        }

        int result = calculate(arr, index - 1);
        return arr[index] + result;
    }
}
