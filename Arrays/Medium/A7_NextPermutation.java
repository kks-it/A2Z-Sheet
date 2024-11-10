package Arrays.Medium;

import java.util.Arrays;

public class A7_NextPermutation {
    public static void main(String[] args) {
        Solution_A7 sol = new Solution_A7();

        int[] arr = {2, 1, 5, 4, 3, 0, 0};
        sol.nextPermutation(arr);

        for(int num: arr){
            System.out.printf("%d\t", num);
        }
    }
}


class Solution_A7 {
    public void nextPermutation(int[] nums) {
        int breakPoint = -1;

        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                breakPoint = i;
                break;
            }
        }

        if(breakPoint == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for(int i = nums.length - 1; i > breakPoint ; i--){
            if(nums[i] > nums[breakPoint]){
                swap(nums, i, breakPoint);
                break;
            }
        }

        reverse(nums, breakPoint + 1, nums.length - 1);
    }

    private void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
