package Recursion.Medium;

import java.util.Stack;

public class SortStack {
    public static void main(String... args){
        Solution sol = new Solution();

        Stack<Integer> st= new Stack<>();
        st.push(4);
        st.push(1);
        st.push(5);
        st.push(2);
        st.push(3);

        System.out.println(st);
        sol.sortStack(st);
        System.out.println(st);
    }

    static class Solution {
        public void sortStack(Stack<Integer> st) {
            // Your code goes here
            if(st.isEmpty())
                return;

            Integer num = st.pop();
            sortStack(st);

            insertAtCorrectPosition(st, num);
        }

        public void insertAtCorrectPosition(Stack<Integer> st, Integer num){
            if(st.isEmpty()){
                st.push(num);
                return;
            }

            if(st.peek() < num){
                st.push(num);
                return;
            }

            int top = st.pop();
            insertAtCorrectPosition(st, num);
            st.push(top);
        }
    }
}
