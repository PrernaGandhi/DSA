package com.dsa.interview.questions.reverse_words;

/*
    reverse words

            Input           |       Output
 ---------------------------|-------------------
    "the sky is blue"       |   "blue is sky the"
    "coding is fun"         |   "fun is coding"
    "   hello world!    "   |   "world! hello"

    Leading and trailing zeroes should be eliminated
    Reduce multiple spaces between two words

    Approach :
       1.   Reverse each word
       2.   Reverse each string

       "the sky is blue"
            Step 1 : reverse each word : "eht yks si eulb"
            Step 2 : reverse complete string : "blue is sky the"

 */
public class ReverseWords {
    public String reverseWords(String string) {
        int startPointer = 0;
        int endPointer = 0;

        while (startPointer < string.length() && endPointer < string.length()) {
            if (string.charAt(endPointer) == ' ') {
                // reverse word
                string = reverse(string, startPointer, endPointer - 1);
                endPointer++;
                startPointer = endPointer;
            } else {
                endPointer++;
            }
        }
        // reverse the last word
        string = reverse(string, startPointer, endPointer - 1);
        // reverse the complete string
        string = reverse(string, 0, string.length() - 1);

        StringBuilder answer = new StringBuilder();
        int i = 0;
        while (string.charAt(i) == ' ') i++;    // handling leading zeroes
        while (i < string.length()) {
            if (string.charAt(i) == ' ') {
                // add a single space
                answer.append(' ');
                i++;
                // if there are more spaces, we don't add it to the answer string
                while (i < string.length() && string.charAt(i) == ' ') {
                    i++;
                }
            } else {
                answer.append(string.charAt(i));
                i++;
            }
        }
        // if there would be a trailing spaces, it would be only one due to the above block of code
        if (answer.charAt(answer.length() - 1) == ' ') {
            answer.deleteCharAt(answer.length() - 1);
        }
        return answer.toString();
    }

    // O(N/2)
    public String reverse(String string, int startPointer, int endPointer) {
        char[] chars = string.toCharArray();
        while (startPointer <= endPointer) {
            swap(chars, startPointer, endPointer);
            startPointer++;
            endPointer--;
        }
        return String.valueOf(chars);
    }

    // O(1)
    private void swap(char[] chars, int startPointer, int endPointer) {
        char temp = chars[startPointer];
        chars[startPointer] = chars[endPointer];
        chars[endPointer] = temp;
    }
}