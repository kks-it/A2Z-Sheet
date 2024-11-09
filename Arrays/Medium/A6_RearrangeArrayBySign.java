package Arrays.Medium;

import java.util.Arrays;

public class A6_RearrangeArrayBySign {
    public static void main(String[] args) {
        Solution_A6 sol = new Solution_A6();

        int[] arr = {3,1,-2,-5,2,-4};
        int[] result = sol.rearrangeArray(arr);

        System.out.println("rearranged array: ");
        Arrays.stream(result).forEach(n -> System.out.printf("%d  ", n));

    }
}

class Solution_A6 {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];

        int i = 0, pi = 0, ni = 1;
        while(i < nums.length){
            if(nums[i] >= 0){
                result[pi] = nums[i];
                pi += 2;
            }else{
                result[ni] = nums[i];
                ni += 2;
            }
            i++;
        }

        return result;
    }
}
