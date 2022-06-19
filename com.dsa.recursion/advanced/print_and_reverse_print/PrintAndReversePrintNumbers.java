package advanced.print_and_reverse_print;

public class PrintAndReversePrintNumbers {
    private void print(String string, int currentIndex) {
        if (currentIndex == string.length()) {
            return;
        }

        System.out.print(string.charAt(currentIndex));
        print(string, currentIndex + 1);

    }

    private void reversePrint(String string, int currentIndex) {
        if (currentIndex == string.length()) {
            return;
        }

        reversePrint(string, currentIndex + 1);
        System.out.print(string.charAt(currentIndex));

    }

    public void printNumbers(String string) {
        print(string, 0);
        System.out.println();
        reversePrint(string, 0);
    }
}
