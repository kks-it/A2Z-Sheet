package zOtherQuestions.Daily.Nov2025.Easy;

public class _1And2BitsCharacters {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] test1 = {1,0,0};
        System.out.println(sol.isOneBitCharacter(test1));


        int[] test2 = {1,1,1,0};
        System.out.println(sol.isOneBitCharacter(test2));

        int[] test3 = {1,1,0,0};
        System.out.println(sol.isOneBitCharacter(test3));

    }

    static class Solution {
        public boolean isOneBitCharacter(int[] bits) {

            for(int i = 0; i < bits.length;){
                if(i == bits.length - 1){
                    return true;
                }

                if(bits[i] == 1){
                    i += 2;
                }else{
                    i++;
                }
            }

            return false;
        }
    }
}
