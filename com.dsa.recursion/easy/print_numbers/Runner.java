package easy.print_numbers;

public class Runner {
    public static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers();
        printNumbers.ascending(5);
        System.out.println();
        printNumbers.descending(5);
    }
}
