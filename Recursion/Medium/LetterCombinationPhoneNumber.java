package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhoneNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.letterCombinations("23"));
        System.out.println(sol.letterCombinations("2"));
    }

    static class Solution {
        Map<Character, String> map = Map.ofEntries(
                Map.entry('2', "abc"),
                Map.entry('3', "def"),
                Map.entry('4', "ghi"),
                Map.entry('5', "jkl"),
                Map.entry('6', "mno"),
                Map.entry('7', "pqrs"),
                Map.entry('8', "tuv"),
                Map.entry('9', "wxyz")
        );

        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();

            f(digits, 0, new StringBuilder(), result);

            return result;
        }

        public void f(String digits, int idx, StringBuilder sb, List<String> result){
            if(idx == digits.length()){
                result.add(sb.toString());
                return;
            }

            String values = map.get(digits.charAt(idx));

            for(char ch: values.toCharArray()){
                sb.append(ch);
                f(digits, idx + 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
