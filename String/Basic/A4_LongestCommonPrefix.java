package String.Basic;

public class A4_LongestCommonPrefix {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] arr = {"flower","flow","flight"};
        String result = sol.longestCommonPrefix(arr);

        System.out.println("result: " + result);
    }
}


class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        StringBuilder result = new StringBuilder();

        while(true){
            char ch = 'a';
            if(i < strs[0].length()){
                ch = strs[0].charAt(i);
            }

            boolean isCommon = true;
            for(String str: strs){
                if (i == str.length() || str.charAt(i) != ch) {
                    isCommon = false;
                    break;
                }
            }
            if(!isCommon)
                break;
            result.append(ch);
            i++;
        }

        return result.toString();
    }
}


