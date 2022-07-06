package com.dsa.dp.work_break;

import java.util.List;

/*
Given a string s and a dictionary of strings wordDict, return true
if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

s = "" , wordDict = ["leet","code"]
--> not a valid case
string length starts from 1


s = "leet", wordDict = ["leet","code"]
s in wordDict, then true
startIndex, endIndex
0   1
l => no
end ++
le => no
end++
lee => no
end++
leet => yes
end++
start = end
s.length == start
true


s -> 0 and check at every point if there exists a word in the dictionary
s = "leetcode", wordDict = ["leet","code"]

0   1
l => no
end++
le => no
end ++
lee => no
end++
leet => yes
end++
start = end
start ==  s.length
return true
end == s.length
return false
else
end++
c => no
end++
co => no
end++
cod => no
end++
code => yes
end++
start = end
start == s.length
return true

 */
public class WordBreak {
    // leeet [leet, code]
    // O(N)
    private boolean isPresent(String string, List<String> wordDict, int startIndex, int endIndex) {
        if (endIndex > string.length()) {
            return false;
        }
        // list contains has O(N) complexity
        // list substring has O(1) complexity
        if (wordDict.contains(string.substring(startIndex, endIndex))) {
            if (endIndex == string.length()) {
                return true;
            } else {
                startIndex = endIndex;
                endIndex++;
            }
        } else {
            endIndex++;
        }
        return isPresent(string, wordDict, startIndex, endIndex);
    }

    public boolean isPresentInDictionary(String string, List<String> wordDict) {
        return isPresent(string, wordDict, 0, 1);
    }
}
