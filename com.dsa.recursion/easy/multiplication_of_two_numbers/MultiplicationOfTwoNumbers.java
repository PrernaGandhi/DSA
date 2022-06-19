package easy.multiplication_of_two_numbers;

/*
    We need to multiply two numbers, but we can't use the multiply operator
    We need to use the plus operator

    m*n == m + m + m + ............. n times

 */
public class MultiplicationOfTwoNumbers {
    public int calculate(int numberOne, int numberTwo) {
        if (numberTwo == 0) {
            return 0;
        }

        int result = calculate(numberOne, numberTwo - 1);

        return numberOne + result;
    }
}
