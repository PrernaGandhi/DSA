package easy.euclidean_algorithm;

/*
    Euclidean Algorithm : To find greatest common divisor(GCD) of two numbers
    Greatest common divisor means the greatest number that divides both the
    given number
    GCD of 8 and 14 is 2
    GCD of 8 and 12 is 4
    GCD of 24 and 9 is 3
 */
public class EuclideanAlgorithm {
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
