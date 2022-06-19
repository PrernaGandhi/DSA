package easy.count_number_of_zeroes;

public class Runner {
    public static void main(String[] args) {
        CountNumberOfZeroes countNumberOfZeroes = new CountNumberOfZeroes();
        System.out.println(countNumberOfZeroes.calculate(10320));
        System.out.println(countNumberOfZeroes.calculate(1032000));
        System.out.println(countNumberOfZeroes.calculate(1000000));
        System.out.println(countNumberOfZeroes.calculate(10000001));
    }
}
