package euclidean_algorithm;

public class EuclideanAlgorithm {
    public int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
