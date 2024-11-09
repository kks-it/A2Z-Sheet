package Arrays.Medium;

// Intuition: only -ve no. of creates challenge, otherwise answer will always be entire array.
// Among -ve numbers, which causes -ve prefix sum need to be removed.

// question 1: return value
// question 2: return actual array

import java.util.Arrays;

public class A4_MaximumSubArray_Kadane_Algorith {
    public static void main(String[] args) {
        Solution_A4 sol = new Solution_A4();

        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

        int result = sol.maxSubArrayValue(arr);
        System.out.printf("result: %d \n", result);


        int[] subArray = sol.maxSubArray(arr);
        System.out.println("max sub array: ");
        Arrays.stream(arr).forEach(n -> System.out.printf("%d  ", n));

    }
}


class Solution_A4 {
    public int maxSubArrayValue(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            sum += num;

            maxSum = Math.max(maxSum, sum);

            sum = Math.max(sum, 0);
        }

        return maxSum;
    }


    public int[] maxSubArray(int[] nums){
        int sum = 0, maxSum = Integer.MIN_VALUE, start = 0, startIndex = 0, endIndex = 0;

        for(int i = 0; i < nums.length; i++){
            if(sum == 0){
                start = i;
            }

            sum += nums[i];

            if(sum > maxSum){
                maxSum = sum;
                startIndex = start;
                endIndex = i;
            }

            sum = Math.max(sum, 0);
        }

        int[] maxSubArray = new int[endIndex - startIndex + 1];

        System.arraycopy(nums, startIndex, maxSubArray, 0, maxSubArray.length);

        return maxSubArray;
    }
}