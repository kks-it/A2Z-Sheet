package Recursion.Hard;

public class Atoi {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String test1 = "   +0 123";
        System.out.println(sol.myAtoi(test1));

        String test2 = "20000000000000000000";
        System.out.println(sol.myAtoi(test2));

        String test3 = "0-1";
        System.out.println(sol.myAtoi(test3));

        String test4 = "words and 987";
        System.out.println(sol.myAtoi(test4));

        String test5 = "-91283472332";
        System.out.println(sol.myAtoi(test5));

        String test6 = "-+12";
        System.out.println(sol.myAtoi(test6));

        String test7 = "+1";
        System.out.println(sol.myAtoi(test7));

        String test8 = "123-";
        System.out.println(sol.myAtoi(test8));


    }

    static class Solution {
        public int myAtoi(String s) {
            long res = helper(s, 0, 0, true, null, true);
            return (int) res;
        }

        // sign: +ve represents true, -ve represents false

        public long helper(String s, int idx, long res, boolean wa, Boolean sign, boolean tz){
            if(idx == s.length()){
                if(sign!= null && !sign){
                    return res * -1;
                }
                return res;
            }

            if(s.charAt(idx) == ' ' && wa){
                return helper(s, idx + 1, res, wa, sign, tz);
            }

            if("+-".contains(s.substring(idx, idx + 1)) && sign == null){
                sign = s.charAt(idx) == '+';
                return helper(s, idx + 1, res, false, sign, tz);
            }

            if(s.charAt(idx) == '0' && tz){
                return helper(s, idx + 1, res, false, sign == null || sign, tz);
            }

            if("1234567890".contains(s.substring(idx, idx + 1))){
                res = res * 10 + (s.charAt(idx) - '0');

                if(res > Integer.MAX_VALUE){
                    if(sign != null && !sign)
                        return Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }


                return helper(s, idx + 1, res, false, sign == null || sign, false);
            }


            if(sign!= null && !sign){
                return res * -1;
            }
            return res;

        }
    }
}
