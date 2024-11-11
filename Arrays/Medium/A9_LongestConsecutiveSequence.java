package Arrays.Medium;

import java.util.HashSet;
import java.util.Set;

public class A9_LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution_A9 sol = new Solution_A9();

        int[] arr = {100, 4, 200, 1, 3, 2};

        int ans = sol.longestConsecutive(arr);

        System.out.printf("ans: %d", ans);
    }
}


class Solution_A9 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;
        for (int num : set) {
            int len = 0;
            if (!set.contains(num - 1)) {
                int key = num;
                while (set.contains(key)) {
                    key++;
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}