package SlidingWindownAndTwoPointers;

import java.util.HashMap;
import java.util.Map;

//Sample Input: arr[] = [3, 1, 2, 2, 2, 2]
//Sample Output: 5
//Explanation: It's optimal to pick from the last 5 trees. Please note that we do not pick the first basket as we would have to stop at
//            thrid tree which would result in only 2 fruits collected.

public class A3_FruitIntoBaskets {
    public static void main(String[] args) {
        Integer[] arr = {3, 1, 2, 2, 2, 2};

        int result = Solution_A3.totalFruits(arr);
        System.out.println("result: " + result);

    }
}


class Solution_A3 {
    public static int totalFruits(Integer[] arr) {
        // code here
        int left = -1, right = 0, result = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while(right < arr.length){
            if(map.size() < 2 || map.containsKey(arr[right])){
                map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
                result = Math.max(result, right - left);
                right++;
            }else{
                left++;
                if(map.get(arr[left]) == 1){
                    map.remove(arr[left]);
                }else{
                    map.put(arr[left], map.get(arr[left]) - 1);
                }
            }
        }

        return result;
    }
}
