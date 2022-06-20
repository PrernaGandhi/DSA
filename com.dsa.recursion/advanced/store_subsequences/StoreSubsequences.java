package advanced.store_subsequences;

import java.util.List;

public class StoreSubsequences {

    public List<String> store(String input, String output, List<String> list) {
        if (input.length() == 0) {
            list.add(output);
            return list;
        }
        // exclude the current character
        store(input.substring(1), output, list);
        // include the current character
        store(input.substring(1), output + input.charAt(0), list);

        return list;
    }
}
