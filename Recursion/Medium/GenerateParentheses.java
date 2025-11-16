package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.generateParenthesis(1));
        System.out.println(sol.generateParenthesis(2));
        System.out.println(sol.generateParenthesis(5));
    }

    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();

            generate(2 * n, new StringBuilder(), 0, 0, result);

            return result;
        }

        public void generate(int n, StringBuilder cur, int openCount, int closedCount, List<String> result) {
            if (cur.length() == n) {
                if (openCount == closedCount)
                    result.add(cur.toString());
                return;
            }

            generate(n, cur.append("("), openCount + 1, closedCount, result);
            cur.deleteCharAt(cur.length() - 1);

            if (openCount > closedCount) {
                generate(n, cur.append(")"), openCount, closedCount + 1, result);
                cur.deleteCharAt(cur.length() - 1);
            }

        }
    }

}
