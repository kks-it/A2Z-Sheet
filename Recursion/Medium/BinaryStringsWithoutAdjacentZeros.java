package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryStringsWithoutAdjacentZeros {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.validStrings(1));
        System.out.println(sol.validStrings(5));
        System.out.println(sol.validStrings(9));
    }

    static class Solution {
        public List<String> validStrings(int n) {
            List<String> result = new ArrayList<>();

            generate(n, new StringBuilder(), result);

            return result;
        }

        public void generate(int n, StringBuilder cur, List<String> result){
            if(cur.length() == n){
                result.add(cur.toString());
                return;
            }

            if(cur.isEmpty() || cur.charAt(cur.length() - 1) == '1'){
                generate(n, cur.append("0"), result);
                cur.deleteCharAt(cur.length() - 1);
            }

            generate(n, cur.append("1"), result);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
