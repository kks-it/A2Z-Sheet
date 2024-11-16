package String.Basic;

public class A5_IsomorphicString {
    public static void main(String[] args) {
        Solution_A5 sol = new Solution_A5();

        String s1 = "egg", t1 = "add";
        boolean result1 = sol.isIsomorphic(s1, t1);
        System.out.println("result: " + result1);

        System.out.println();

        String s2 = "foo", t2 = "bar";
        boolean result2 = sol.isIsomorphic(s2, t2);
        System.out.println("result: " + result2);
    }
}


// map is a map to track what mapping s -> t was done when it appeared first time
// if they don't match with current mapping. Return false;

// used is like a set to track if a char in t is already been mapped to some other char in s.
// to ensure no two different chars in s are pointing to same char in t

// always t.charAt(i) + 1 is stored becuase ascii chars starts from 0. but we are also used 0(default value)
// to ensure no mapping is done so far. So, to make sure 0 is only because of defaulf value and not becuase
// of char mapping.

class Solution_A5 {
    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[256];
        boolean[] used = new boolean[256];

        for(int i = 0; i < s.length(); i++){
            if(map[s.charAt(i)] > 0){
                if(map[s.charAt(i)] != t.charAt(i) + 1)
                    return false;
            }else{
                if(used[t.charAt(i) + 1]){
                    return false;
                }
                map[s.charAt(i)] = t.charAt(i) + 1;
                used[t.charAt(i) + 1] = true;
            }
        }
        return true;
    }
}