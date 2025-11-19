package Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Intution to ensure unique combinations:
// Sort the array to get the combination in same order
// combination can be started from any index
// If we are taking the first occurence of a number, we can skip it's other occurence as it will give same combination
// eg. {1, 1, 1, 2, 2} target = 4
// with "empty" cur list, we will get same combination on consuming idx = 0, 1, 2. So we can skip idx = 1, 2
// Similarly, with {1} in cur list, we will get same combination on comsuming idx = 1, 2. i.e, {1, 1}. So we can skip idx = 2.

public class CombinationSumII {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] test1 = {10,1,2,7,6,1,5};
        int target1 = 8;
        System.out.println(sol.combinationSum2(test1, target1));


        int[] test2 = {2,5,2,1,2};
        int target2 = 5;
        System.out.println(sol.combinationSum2(test2, target2));


    }

    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            List<List<Integer>> result = new ArrayList<>();

            Arrays.sort(candidates);

            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < candidates.length; i++) {
                if (i == 0 || candidates[i] != candidates[i - 1]) {
                    cur.addLast(candidates[i]);
                    f(candidates, i + 1, target - candidates[i], cur, result);
                    cur.removeLast();
                }
            }

            return result;

        }

        public void f(int[] candidates, int idx, int target, List<Integer> cur, List<List<Integer>> result) {
            if(target == 0){
                result.add(new ArrayList<>(cur));
                return;
            }

            if(target < 0 || idx == candidates.length)
                return;

            for (int i = idx; i < candidates.length; i++) {
                if (i == idx || candidates[i] != candidates[i - 1]) {
                    cur.addLast(candidates[i]);
                    f(candidates, i + 1, target - candidates[i], cur, result);
                    cur.removeLast();
                }
            }
        }
    }
}
