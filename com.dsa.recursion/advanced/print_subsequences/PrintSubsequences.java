package advanced.print_subsequences;

/*
     A                       ABC
                         /        \
     B                  BC         ABC
                       /  \        /  \
     C                C    BC     AC   ABC
                     / \   / \   / \   / \
                    ""  C B  BC A  AC AB  ABC

    Input String        |       Current Alphabet        |       Include     |       Exclude
 -----------------------|-------------------------------|-------------------|------------------------
        ABC             |               A               |       ABC         |           BC
 -----------------------|-------------------------------|-------------------|------------------------
        BC              |               B               |       BC          |           C
        ABC             |               B               |       ABC         |           AC
 -----------------------|-------------------------------|-------------------|-------------------------
        C               |               C               |       C           |           ""
        BC              |               C               |       BC          |           B
        AC              |               C               |       AC          |           A
        ABC             |               C               |       ABC         |           AB

*/
public class PrintSubsequences {
    public void print(String input, String output) {
        // base case for empty string ""
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }
        // exclude from output string
        print(input.substring(1), output);
        // include in the output string
        print(input.substring(1), output + input.charAt(0));
    }
}
