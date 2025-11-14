package Recursion.Easy;

public class CountGoodNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();

        long digits = 3000L;

        int ans = solution.countGoodNumbers(digits);

        System.out.println(ans);
    }

    static class Solution {
        static int MOD = 1_000_000_007;
        public int countGoodNumbers(long n) {
            long first = binaryExponentiation(5, (n + 1 )/ 2);
            long second = binaryExponentiation(4, n / 2);

            return (int) ((first  * second ) % MOD);
        }

        public static long binaryExponentiation(int a, long b){
            if(b == 0){
                return 1L;
            }


            long res = binaryExponentiation(a, b / 2);
            res = (res * res) % MOD;
            if((b & 1) == 1){
                res =  res * a % MOD;
            }

            return res;
        }
    }
}



