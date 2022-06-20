package advanced.remove_consecutive_duplicates;

public class Runner {
    public static void main(String[] args) {
        RemoveConsecutiveDuplicates removeConsecutiveDuplicates = new RemoveConsecutiveDuplicates();
        String string = "a";
        System.out.println(removeConsecutiveDuplicates.remove(string, 0));
        string = "aaabcccdd";
        System.out.println(removeConsecutiveDuplicates.remove(string, 0));
    }
}
