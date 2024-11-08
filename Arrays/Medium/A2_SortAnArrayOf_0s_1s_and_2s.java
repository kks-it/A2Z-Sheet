package Arrays.Medium;

//Solution: keep two pointer left and right, nums behind the left are 0's and nums ahead of right
// are 2's.
//
// nums between left(included) and i are 1's. nums between i and right(included) are area
// to explore.
// doubt: why i++ when nums[i] == 0 but not i++ when nums[i] == 2
// because we have already explored all nums behind i. So it is guaranteed left will be on 1. but we have
// not explored element on right. So, there is no guarantee and we need to check i again.

public class A2_SortAnArrayOf_0s_1s_and_2s {
    public static void main(String[] args){
        SolutionA2 sol = new SolutionA2();
        int[] nums = {2,0,2,1,1,0};
        sol.sortColors(nums);

        System.out.println("result");
        for(int num: nums){
            System.out.print(num + "\t");
        }
    }
}

class SolutionA2 {
    public void sortColors(int[] nums) {
        int i = 0, left = 0, right = nums.length - 1;

        while(i <= right){
            if(nums[i] == 0){
                swap(nums, i, left);
                i++;
                left++;
            }else if(nums[i] == 1){
                i++;
            }else{
                swap(nums, i, right);
                right--;
            }
        }
    }

    public static void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
