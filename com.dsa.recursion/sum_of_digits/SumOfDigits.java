package sum_of_digits;

public class SumOfDigits {
    public int calculate(int number) {
        // base case
        if (number == 0) {
            return 0;
        }

        // n - 1
        int result = calculate(number / 10);
        // n
        return number % 10 + result;

    }
}
