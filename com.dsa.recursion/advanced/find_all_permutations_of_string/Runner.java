package advanced.find_all_permutations_of_string;

public class Runner {
    public static void main(String[] args) {
        FindAllPermutationsOfString findAllPermutationsOfString = new FindAllPermutationsOfString();
        findAllPermutationsOfString.print("abc".toCharArray(),0);
        System.out.println("---------------------------------");
       findAllPermutationsOfString.print("abcd".toCharArray(),0);
    }
}
