package count_digits;

public class Runner {
    public static void main(String[] args) {
        CountDigits countDigits = new CountDigits();
        System.out.println(countDigits.count(5));
        System.out.println(countDigits.count(50));
        System.out.println(countDigits.count(505));
        System.out.println(countDigits.count(5050));
        System.out.println(countDigits.count(50505));
    }
}
