package easy.count_digits;

public class CountDigits {
    public int count(int number) {
        // base case
        if (number / 10 == 0) {
            return 1;
        }

        // n -1
        int result = count(number / 10);
        // n
        return 1 + result;
    }
}
