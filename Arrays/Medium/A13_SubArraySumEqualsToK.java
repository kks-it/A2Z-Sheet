package Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class A13_SubArraySumEqualsToK {
    public static void main(String... args){
        Solution_A13 sol = new Solution_A13();

        int[] nums = {6,3,-2,4,2,3,5,1,-5,5,6,3};
        int k = 9;
        int ans = sol.subarraySum(nums, k);

        System.out.printf("Number of subarrays having sum equals to %d are: %d", k, ans);

    }
}

class Solution_A13 {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];

            int count = map.getOrDefault(prefixSum - k, 0);
            ans += count;

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return ans;
    }
}
