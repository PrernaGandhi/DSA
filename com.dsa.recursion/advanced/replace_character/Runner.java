package advanced.replace_character;

public class Runner {
    public static void main(String[] args) {
        String str = "hello world";
        char toBeReplaced = 'l';
        char replacement = 'X';
        char[] chars = str.toCharArray();
        ReplaceCharacter replaceCharacter = new ReplaceCharacter();
        System.out.println(replaceCharacter.replace(chars, toBeReplaced, replacement, chars.length - 1));

        str = "yyyyyyy";
        chars = str.toCharArray();
        replaceCharacter = new ReplaceCharacter();
        System.out.println(replaceCharacter.replace(chars, toBeReplaced, replacement, chars.length - 1));

    }
}
