package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] test1 = {1, 2, 3};
        System.out.println(sol.subsets(test1));

        int[] test2 = {0};
        System.out.println(sol.subsets(test2));
    }

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            generatePowerSet(nums, 0, new ArrayList<>(), result);

            return result;
        }

        public void generatePowerSet(int[] nums, int idx, List<Integer> cur, List<List<Integer>> result){
            if(idx == nums.length){
                // base condition
                result.add(new ArrayList<>(cur));
                return;
            }

            generatePowerSet(nums, idx + 1, cur, result);

            cur.add(nums[idx]);
            generatePowerSet(nums, idx + 1, cur, result);
            cur.removeLast();
        }
    }
}
