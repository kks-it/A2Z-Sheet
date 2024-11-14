package String.Basic;

public class A2_LargestOddNumberInString {
    public static void main(String[] args){
        Solution_A2 sol = new Solution_A2();

        String result = sol.largestOddNumber("3542786");

        System.out.printf("result: %s", result);
    }
}


class Solution_A2 {
    public String largestOddNumber(String num) {
        int index = 0;
        for(int i = num.length() - 1; i >= 0;  i--){
            if((int)num.charAt(i) % 2 == 1){
                index = i + 1;
                break;
            }
        }

        return num.substring(0,index);
    }
}
