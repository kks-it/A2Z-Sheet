package Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] test1 = {1,2,2};
        System.out.println(sol.subsetsWithDup(test1));

        int[] test2 = {0};
        System.out.println(sol.subsetsWithDup(test2));

        int[] test3 = {4,4,4,1,4};
        System.out.println(sol.subsetsWithDup(test3));
    }

    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();

            result.add(new ArrayList<>(cur));

            for(int i = 0; i < nums.length; i++){
                if(i == 0 || nums[i] != nums[i - 1]){
                    cur.addLast(nums[i]);
                    f(nums, i + 1, cur, result);
                    cur.removeLast();
                }
            }

            return result;

        }

        public void f(int[] nums, int idx, List<Integer> cur, List<List<Integer>> result){
            result.add(new ArrayList<>(cur));

            if(idx == nums.length)
                return;

            for(int i = idx; i < nums.length; i++){
                if(i == idx || nums[i] != nums[i - 1]){
                    cur.addLast(nums[i]);
                    f(nums, i + 1, cur, result);
                    cur.removeLast();
                }
            }

        }
    }
}
