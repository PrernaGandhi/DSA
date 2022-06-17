package com.dsa.interview.questions.length_of_last_word;

/*
        Input : "      world               "
        Output : 5

        Input : "hello   world"
        Output : 5

        Input : ""
        Output : 0
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String line) {
        String[] strings = line.split("\\s+");
        return strings[strings.length - 1].length();
    }
}
