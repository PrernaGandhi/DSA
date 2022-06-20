package advanced.remove_character;

public class Runner {
    public static void main(String[] args) {
        RemoveCharacter removeCharacter = new RemoveCharacter();
        String string = "abcdabef";
        System.out.println(removeCharacter.remove(string, 'a', 0));
        string = "abcdsdaabef";
        System.out.println(removeCharacter.remove(string, 'a', 0));
        string = "abcdsdaabef";
        System.out.println(removeCharacter.remove(string, 'b', 0));
    }
}
