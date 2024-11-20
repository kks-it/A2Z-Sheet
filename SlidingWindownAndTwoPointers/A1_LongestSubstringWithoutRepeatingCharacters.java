package SlidingWindownAndTwoPointers;

public class A1_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution_A1 sol = new Solution_A1();

        int result = sol.lengthOfLongestSubstring("abcabcbb");
        System.out.println("result: " + result);
    }
}

class Solution_A1 {
    public int lengthOfLongestSubstring(String s) {
        int left = -1, right = 0, result = 0;
        boolean[] set = new boolean[256];

        while(right < s.length()){
            char ch = s.charAt(right);
            if(set[ch]){
                left++;
                set[s.charAt(left)] = false;
            }else{
                set[ch] = true;
                result = Math.max(result, right - left);
                right++;
            }
        }

        return result;
    }
}

//acquire using right
// compare the current length i.e right - left + 1 with max

// if duplicate
// move left and remove from set till upcoming element's previous occurance is removed
//acquire using right
// compare the current length i.e right - left + 1 with max

// if duplicate
// move left and remove from set till upcoming element's previous occurance is removed
