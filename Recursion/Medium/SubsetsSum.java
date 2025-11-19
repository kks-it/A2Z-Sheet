package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class SubsetsSum {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] test1 = {1, 2, 1};
        System.out.println(sol.subsetSums(test1));

        int[] test2 = {5, 6, 7};
        System.out.println(sol.subsetSums(test2));
    }

    static // User function Template for Java//User function Template for Java
    class Solution {
        public ArrayList<Integer> subsetSums(int[] arr) {
            // code here
            ArrayList<Integer> result = new ArrayList<>();
            f(arr, 0, 0, result);
            return result;
        }

        public void f(int[] nums, int idx, int sum, List<Integer> result){
            if(idx == nums.length){
                result.add(sum);
                return;
            }

            f(nums, idx + 1, sum, result);
            f(nums, idx + 1, sum + nums[idx], result);
        }
    }
}
