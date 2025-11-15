package Recursion.Medium;


public class PowX_BinaryExponential {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.myPow(2.00000, 10));
        System.out.println(sol.myPow(34.00515, -3));
        System.out.println(sol.myPow(1.00000, -2147483648));
    }

    static class Solution {
        public double myPow(double x, int n) {
            //your code goes here
            if (n == 0) {
                return 1;
            }

            if (n == -1) {
                return 1 / x;
            }

            double ans = myPow(x, n / 2);

            ans = ans * ans;

            if ((n & 1) == 1) {
                if (n > 0)
                    ans *= x;
                else
                    ans *= 1 / x;
            }

            return ans;
        }
    }
}
