package fibonacci;

public class Fibonacci {

    public int headRecursion(int n) {
        // base cases
        if(n == 0) return 0;
        if(n == 1) return 1;

        // call recursively
        int fib1 = headRecursion(n - 1);
        int fib2 = headRecursion(n -2);

        // do something
        int result = fib1 + fib2;

        return result;
    }

    public int tailRecursion(int n, int result1, int result2) {
        // base cases
        if(n == 0) return result1;
        if(n == 1) return result2;

        // do something
        int result = result1 + result2;

        // call recursively
        return tailRecursion(n-1, result2 ,result);
    }
}