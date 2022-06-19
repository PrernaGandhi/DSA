package easy.geometric_sum;

public class GeometricSum {
    public double calculate(int k) {
        if (k == 0) {
            return 1;
        }

        double result = calculate(k - 1);

        return 1.0 / Math.pow(2, k) + result;
    }
}
