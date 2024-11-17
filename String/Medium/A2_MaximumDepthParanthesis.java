package String.Medium;

// Better solution than using stack: use counter
// Space complexity: O(1)

public class A2_MaximumDepthParanthesis {
    public static void main(String[] args) {
        Solution_A2 sol = new Solution_A2();

        int maxDepth = sol.maxDepth("(1+(2*3)+((8)/4))+1");

        System.out.println("maximum depth: " + maxDepth);
    }
}


class Solution_A2 {
    public int maxDepth(String s) {
        int count = 0, maxDepth = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                count++;
                maxDepth = Math.max(maxDepth, count);
            }else if(ch == ')'){
                count--;
            }
        }

        return maxDepth;
    }
}