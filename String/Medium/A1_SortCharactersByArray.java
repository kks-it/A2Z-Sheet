package String.Medium;

import java.util.*;

public class A1_SortCharactersByArray {
    public static void main(String[] args) {
        Solution_A1 sol = new Solution_A1();

        String sorted = sol.frequencySort("tree");

        System.out.println("result: " + sorted);
    }
}


class Solution_A1 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}