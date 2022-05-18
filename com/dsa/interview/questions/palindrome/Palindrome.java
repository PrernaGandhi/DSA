package com.dsa.interview.questions.palindrome;

public class Palindrome {

    // 'madam' --> true

    // O(N) time complexity
    public boolean checkIfPalindrome(String string) {
        int i = 0;
        int j = string.length() - 1;

        while ( j >= i) {
            if(string.charAt(i) != string.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
