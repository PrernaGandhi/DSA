package intermediate.sum_of_array;

public class Runner {
    public static void main(String[] args) {
        SumOfArray sumOfArray = new SumOfArray();
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(sumOfArray.calculate(array, array.length - 1));
        array = new int[]{10, 20, 30, 40};
        System.out.println(sumOfArray.calculate(array, array.length - 1));
    }
}
