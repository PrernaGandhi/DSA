package easy.fibonacci;

/*
    Fibonacci series : 0 1 1 2 3 5 8 13 21
 */
public class Fibonacci {

    /*
        head recursion steps :
            step 1: base cases
            step 2: call recursively
            step 3: do something

        disadvantage :
        stores stack frames till the base condition is reached,
        therefore, might result in stack overflow error

     */
    public int headRecursion(int n) {
        // base cases
        if (n == 0) return 0;
        if (n == 1) return 1;

        // call recursively
        int fib1 = headRecursion(n - 1);
        int fib2 = headRecursion(n - 2);

        // do something
        int result = fib1 + fib2;

        return result;
    }

    /*
        tail recursion steps :
            step 1: base cases
            step 2: do something
            step 3: call recursively

     */
    public int tailRecursion(int n, int result1, int result2) {
        // base cases
        if (n == 0) return result1;
        if (n == 1) return result2;

        // do something
        int result = result1 + result2;

        // call recursively
        return tailRecursion(n - 1, result2, result);
    }
}