package print_numbers;

public class PrintNumbers {
    public void ascending(int n) {
        // base case
        if (n == 0)
            return;
        // f(n -1)
        ascending(n - 1);
        System.out.print(n + " ");
    }

    public void descending(int n) {
        // base case
        if (n == 0)
            return;
        // f(n -1)
        System.out.print(n + " ");
        descending(n - 1);
    }
}
