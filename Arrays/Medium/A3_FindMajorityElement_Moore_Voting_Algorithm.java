package Arrays.Medium;

// To find the majority element which appears more than n/2 times

// Moore's voting algorithm intuition: The algorithm exploits the principle of "cancelling out" non-majority elements and relies
// on the fact that if a majority element exists, it will remain the dominant candidate by the end of the array traversal.

public class A3_FindMajorityElement_Moore_Voting_Algorithm {
    public static void main(String[] args) {
        Solution_A3 sol = new Solution_A3();

        int[] arr = {2,2,1,1,1,2,2};

        int result = sol.majorityElement(arr);
        System.out.printf("result: %d%n", result);
    }
}

class Solution_A3 {
    public int majorityElement(int[] nums) {
        int element = nums[0], count = 0;

        for(int num: nums){
            if(count == 0){
                element = num;
            }
            if(num == element){
                count++;
            }else{
                count--;
            }
        }

        return element;
    }
}