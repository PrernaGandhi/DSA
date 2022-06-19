package advanced.length_of_character_array;

public class Runner {
    public static void main(String[] args) {
        LengthOfCharacterArray length = new LengthOfCharacterArray();
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        System.out.println(length.length(chars, chars.length - 1));
    }
}
