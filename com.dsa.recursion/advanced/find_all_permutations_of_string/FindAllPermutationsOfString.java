package advanced.find_all_permutations_of_string;

/*

 */
public class FindAllPermutationsOfString {
    public void print(char[] str, int currIndex) {
        if (str.length == currIndex) {
            System.out.println(str);
            return;
        }
        for (int i = currIndex; i < str.length; i++) {
            str = swapMethod(str, currIndex, i);
            print(str, currIndex + 1);
            str = swapMethod(str, currIndex, i);
        }
    }

    public char[] swapMethod(char[] input, int i1, int i2) {
        char temp = input[i1];
        input[i1] = input[i2];
        input[i2] = temp;
        return input;
    }
}
