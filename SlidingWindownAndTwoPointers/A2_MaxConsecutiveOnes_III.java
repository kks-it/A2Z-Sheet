package SlidingWindownAndTwoPointers;

public class A2_MaxConsecutiveOnes_III {
    public static void main(String[] args) {
        Solution_A2 sol = new Solution_A2();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        int result = sol.longestOnes(nums, k);
        System.out.println("result: " + result);
    }
}

class Solution_A2 {
    public int longestOnes(int[] nums, int k) {
        int left = -1, right = 0, result = 0, zerosCount = 0;

        while(right < nums.length){
            if(nums[right] == 1 || zerosCount < k){
                //move right pointer
                result = Math.max(result, right - left);
                if(nums[right] == 0){
                    zerosCount++;
                }
                right++;
            }else{
                //move left pointer
                left++;
                if(nums[left] == 0){
                    zerosCount--;
                }
            }
        }

        return result ;
    }
}

