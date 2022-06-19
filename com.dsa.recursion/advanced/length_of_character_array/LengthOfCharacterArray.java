package advanced.length_of_character_array;

public class LengthOfCharacterArray {
    public int length(char[] chars, int currentIndex) {
        if (currentIndex == -1) {
            return 0;
        }

        int result = length(chars, currentIndex - 1);
        return 1 + result;
    }
}
