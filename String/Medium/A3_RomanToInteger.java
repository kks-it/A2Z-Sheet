package String.Medium;

import java.util.HashMap;
import java.util.Map;

public class A3_RomanToInteger {
    public static void main(String[] args) {
        SolutionA3 sol = new SolutionA3();

        int num = sol.romanToInt("MCMXCIV");
        System.out.println(num);

    }
}

class SolutionA3 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int num = 0;
        for(int i = 0; i < s.length() - 1; i++){
            if((s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) ||
                    (s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) ||
                    (s.charAt(i) == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M'))

            ){
                num -= map.get(s.charAt(i));
            }else{
                num += map.get(s.charAt(i));
            }
        }

        num += map.get(s.charAt(s.length() - 1));

        return num;

    }
}
