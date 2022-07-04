package com.dsa.dp.minimum_distance;

/*
        Given two words, we need to convert word one to word two
        with the following operations
        Insert a character,
        Delete a character,
        Replace a character

        "horse" -> "ros"

        replace 'h' by 'r'
    =>    "horse" => "rorse"
        remove 'r'
    =>    "rorse" => "rose"
        remove 'e'
    =>    "rose" => "ros"

    3 moves taken

 */
public class MinDistance {

    int convert(String str, String target, int m, int n) {
        if (m == 0) {
            return n;   // insert all characters to string
        }
        if (n == 0) {
            return m;   // delete all characters of string
        }
        if (str.charAt(m - 1) == target.charAt(n - 1)) {
            return convert(str, target, m - 1, n - 1);
        }
        int insert = convert(str, target, m, n - 1);
        int delete = convert(str, target, m - 1, n);
        int replace = convert(str, target, m - 1, n - 1);
        return 1 + Math.min(insert, Math.min(delete, replace));

    }

    int convert(String str, String target) {
        return convert(str, target, str.length(), target.length());
    }
}
