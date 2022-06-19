package easy.count_number_of_zeroes;

public class CountNumberOfZeroes {
    public int calculate(int number) {
        if (number == 0) {
            return 0;
        }

        int result = calculate(number / 10);
        if (number % 10 == 0) {
            result = result + 1;
        }
        return result;
    }
}
