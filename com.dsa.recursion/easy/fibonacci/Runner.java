package easy.fibonacci;

public class Runner {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.headRecursion(10));
        System.out.println(fibonacci.tailRecursion(10, 0, 1));
    }
}
