package intermediate.check_palindrome;

public class Runner {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 1};
        CheckPalindrome checkPalindrome = new CheckPalindrome();
        System.out.println(checkPalindrome.isPalindrome(array, 0, array.length - 1));
        array = new int[]{1, 2, 2, 1};
        System.out.println(checkPalindrome.isPalindrome(array, 0, array.length - 1));
        array = new int[]{1, 2, 2, 1, 2};
        System.out.println(checkPalindrome.isPalindrome(array, 0, array.length - 1));
    }
}
