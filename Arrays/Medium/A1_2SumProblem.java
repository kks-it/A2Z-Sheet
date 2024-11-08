package Arrays.Medium;

import java.util.Map;
import java.util.HashMap;

// solution: Use hashmap to avoid multiple lookups

public class A1_2SumProblem{
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] arr = {2,7,11,15};
        int[] result = sol.twoSum( arr, 18);

        for(int num: result){
            System.out.println(num + "\t");
        }
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i] ;
            if(map.containsKey(complement)){
                result[0] = map.get(complement);
                result[1] = i;
            }else{
                map.put(nums[i], i);
            }
        }

        return result;
    }
}