package advanced.store_subsequences;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        StoreSubsequences storeSubsequences = new StoreSubsequences();
        System.out.println(storeSubsequences.store("", "", new ArrayList<>()));
        System.out.println(storeSubsequences.store("abc", "", new ArrayList<>()));
    }
}
