package intermediate.check_palindrome;

public class CheckPalindrome {
    public boolean isPalindrome(int[] array, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            return true;
        }

        boolean isPalindrome = isPalindrome(array, startIndex + 1, endIndex - 1);

        if (!isPalindrome) {
            return false;
        }

        if (array[startIndex] == array[endIndex]) {
            return true;
        } else {
            return false;
        }
    }
}
