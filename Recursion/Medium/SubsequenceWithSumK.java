package Recursion.Medium;

public class SubsequenceWithSumK {
    public static void main(String[] args) {
        int[] test1 = {10,1,2,7,6,1,5};
        int k1 = 9;
        System.out.println(Solution.checkSubsequenceSum(test1, k1));
    }

    static class Solution {
        public static boolean checkSubsequenceSum(int[] arr, int K) {
            // code here
            return checkSum(arr, 0, 0, K);

        }

        public static boolean checkSum(int[] nums, int idx, int cur, int k){
            if(cur == k){
                return true;
            }

            if(cur > k || idx == nums.length) // very important to return if cur > k otherwise TLE
                return false;

            return checkSum(nums, idx + 1, cur + nums[idx], k) || checkSum(nums, idx + 1, cur, k);
        }
    }

}
