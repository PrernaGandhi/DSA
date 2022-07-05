package com.dsa.dp.edit_distance;

/*
        word 1 : "horse"
        word 2 : "ros"


        Operations allowed:
            1.  insert a character
            2.  delete a character
            3.  replace a character


      "horse"       "ros"
       ^             ^
       |             |
       i             j


        char[i] == char[j]
            i+1, j+1
        char[i] != char[j]
            insert      i, j+1          1
            delete      i+1, j          1
            replace     i+1, j+1        1


      i=0, j=0
        "h" != "r"                steps         i           j
        insert      rhorse          1           0           1
        delete      orse            1           1           0
        replace     rorse           1           1           1

        min = 1

          i=0, j=1
          "horse"       "ros"
           ^              ^
           |              |
           i              j

            "h"!="o"      steps         i           j
            insert          1+1           0           2
            delete          1+1           1           1
            replace         1+1           1           2
            min = 2

               i=0, j=2
              "horse"       "ros"
               ^               ^
               |               |
               i               j

                "h"!="s"
                insert      2+1         0           3 =>
                delete






 */
public class EditDistance {

    private int noOfSteps(String word1, int i, String word2, int j) {
        if (i == word1.length() || j == word2.length()) {
            return word1.length() - i + word2.length() - j;
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return noOfSteps(word1, i + 1, word2, j + 1);
        } else {
            int insert = noOfSteps(word1, i, word2, j + 1);
            int delete = noOfSteps(word1, i + 1, word2, j);
            int replace = noOfSteps(word1, i + 1, word2, j + 1);
            return 1 + Math.min(insert, Math.min(delete, replace));
        }

    }

    public int noOfSteps(String word1, String word2) {
        return noOfSteps(word1, 0, word2, 0);
    }
}
