package com.dsa.interview.questions.remove_k_adjacent_duplicates;

import java.util.Stack;

/*
            Input           |   k   |   Output
    ------------------------|-------|-----------
        "abcd"              |   2   |   "abcd"
      "deeedbbcccbdaa"      |   3   |   "aa"
    "pbbcggttciiippooaais"  |   2   |   "ps"
    "ddaabbaaabcccaee"      |   3   |   "ddee"

 */
public class RemoveKAdjacentDuplicates {

    class Pair {
        private char character;
        private int frequency;

        public char getCharacter() {
            return character;
        }

        public void setCharacter(char character) {
            this.character = character;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }
    }

    public String removeKAdjacentKAdjacentDuplicates(String string, int k) {
        Stack<Pair> stack = new Stack<>();
        Pair pair;
        for (Character character :
                string.toCharArray()) {
            // if stack is empty or the top element is not equal to given character
            // then we add a new pair for the given character with frequency 1
            if (stack.isEmpty() || stack.peek().getCharacter() != character) {
                pair = new Pair();
                pair.setCharacter(character);
                pair.setFrequency(1);
                stack.push(pair);
            }
            // otherwise we add one to the existing frequency
            else {
                pair = stack.pop();
                pair.setFrequency(pair.getFrequency() + 1);
                if (pair.getFrequency() != k) {
                    stack.push(pair);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            pair = stack.pop();
            int frequency = pair.getFrequency();
            while (frequency != 0) {
                stringBuilder.append(pair.getCharacter());
                frequency--;
            }
        }
        return stringBuilder.reverse().toString();
    }
}