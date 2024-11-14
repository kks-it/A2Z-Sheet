package String.Basic;

public class A1_RemoveOutmostParenthesis {
    public static void main(String[] args) {
        Solution_A1 sol = new Solution_A1();

        String result = sol.removeOuterParentheses("(()())(())(()(()))");

        System.out.printf("result: %s", result);
    }
}


class Solution_A1 {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                if (count > 0) {
                    sb.append(ch);
                }
                count++;
            } else {
                if (count > 1) {
                    sb.append(ch);
                }
                count--;
            }
        }
        return sb.toString();
    }
}
