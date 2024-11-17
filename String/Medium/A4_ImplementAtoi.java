package String.Medium;

// This is a very good question just because of edge cases

//Kya seekha: Never take edge cases for granted.
//1. always make sure to handle edge cases
//    a. empty input
//    b. if we need to check index out of bound
//    c. maximum edge case
//    d. handle conversion things in case of long and int
//    e. we can explictly cast long to int but not Long to int

public class A4_ImplementAtoi {
    public static void main(String[] args) {
        Solution_A4 sol = new Solution_A4();

        int result = sol.myAtoi("1337c0d3");
        System.out.println(result);
    }
}

class Solution_A4 {
    public int myAtoi(String s) {
        int i = 0, sign = 1;

        while(i < s.length() && s.charAt(i) == ' ')
            i++;

        // check sign
        if(i < s.length() && s.charAt(i) == '-'){
            i++;
            sign = -1;
        }else if(i < s.length() && s.charAt(i) == '+'){
            i++;
        }


        long result = 0;
        while(i < s.length() && (int) s.charAt(i) >= 48 && (int) s.charAt(i) <= 57){
            result *= 10;
            result += s.charAt(i) - '0';

            if(sign * result >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }

            if(sign * result <= Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }



        return sign * (int) result ;

    }
}



