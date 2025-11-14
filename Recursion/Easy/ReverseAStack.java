package Recursion.Easy;

// Reverse a stack using recursion(no loops)
//Your solution must modify the input stack in-place to reverse the order of its elements.

import java.util.Stack;

public class ReverseAStack {
    public static void main(String... args){
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);



        System.out.println("stack before: " + stack);

        Solution sol = new Solution();
        sol.reverseStack(stack);

        System.out.println("stack reversed: " + stack);
    }

    static class Solution {
        public void reverseStack(Stack<Integer> st) {

            if(st.isEmpty()){
                return;
            }

            Integer num = st.pop();
            reverseStack(st);

            insertAtBotton(st, num);

        }

        public void insertAtBotton(Stack<Integer> st, Integer ele){
            if(st.isEmpty()){
                st.push(ele);
                return;
            }

            Integer num = st.pop();
            insertAtBotton(st, ele);
            st.push(num);
        }
    }

}




