package Recursion.Medium;

import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
//        Example 1:
//
//        Input: s = "leetcode", wordDict = ["leet","code"]
//        Output: true
//        Explanation: Return true because "leetcode" can be segmented as "leet code".
//                Example 2:
//
//        Input: s = "applepenapple", wordDict = ["apple","pen"]
//        Output: true
//        Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//                Note that you are allowed to reuse a dictionary word.
//                Example 3:
//
//        Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//        Output: false
    }

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int[] mem = new int[s.length() + 1];
            return f(s, wordDict, 0, mem);
        }

        public boolean f(String s, List<String> wordDict, int idx, int[] mem){
            if(idx == s.length())
                return true;

            if(mem[idx] == -1)
                return false;

            for(String word: wordDict){
                if(s.substring(idx).startsWith(word)){
                    if(f(s, wordDict, idx + word.length(), mem)){
                        return true;
                    }
                }
            }

            mem[idx] = -1;
            return false;
        }
    }
}
