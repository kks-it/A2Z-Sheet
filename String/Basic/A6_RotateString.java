package String.Basic;

public class A6_RotateString {
    public static void main(String[] args) {
        Solution_A6 sol = new Solution_A6();

        String s = "abcde", goal = "cdeab";
        boolean result = sol.rotateString(s, goal);
        System.out.println(result);

        String s2 = "abcde", goal2 = "abced";
        boolean result2 = sol.rotateString(s2, goal2);
        System.out.println(result2);
    }
}


class Solution_A6 {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal) ;
    }
}