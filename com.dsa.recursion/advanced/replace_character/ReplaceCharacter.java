package advanced.replace_character;

public class ReplaceCharacter {
    public char[] replace(char[] chars, char toBeReplaced, char replacement, int currentIndex) {
        if (currentIndex == -1) {
            return chars;
        }

        chars = replace(chars, toBeReplaced, replacement, currentIndex - 1);
        if (chars[currentIndex] == toBeReplaced) {
            chars[currentIndex] = replacement;
        }
        return chars;
    }
}
