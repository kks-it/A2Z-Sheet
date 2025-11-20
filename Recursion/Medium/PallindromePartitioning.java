package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class PallindromePartitioning {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.partition("aab"));
        System.out.println(sol.partition("a"));
    }

    static class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();

            f(s, 0, new StringBuilder(), result);

            return result;
        }

        public void f(String s, int idx, StringBuilder sb, List<List<String>> result){
            if(idx == s.length() - 1){
                // base condition
                sb.append(s.charAt(idx));
                String[] res = sb.toString().split(",");

                boolean areAllPallindrome = true;
                for(String str: res){
                    if(!isPallindrome(str)){
                        areAllPallindrome = false;
                        break;
                    }
                }

                if(areAllPallindrome){
                    result.add(Arrays.asList(res));
                }
                sb.deleteCharAt(sb.length() - 1);
                return;
            }

            sb.append(s.charAt(idx));
            sb.append(",");
            f(s, idx + 1, sb, result);

            sb.deleteCharAt(sb.length() - 1);

            f(s, idx + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }

        public boolean isPallindrome(String str){
            int low = 0, high = str.length() - 1;

            while(low < high){
                if(str.charAt(low) != str.charAt(high))
                    return false;
                low++;
                high--;
            }

            return true;
        }
    }
}
