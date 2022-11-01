package StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class PrevSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {

        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<A.size();i++) {
            while(!st.isEmpty() && A.get(i) <= st.peek()) {
                st.pop();
            }

            if(st.isEmpty())
                ans.add(-1);
            else
                ans.add(st.peek());

            st.push(A.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * THE APPROACH IS THE SAME APPROACH USED FOR GETTING NEXT GREATER ELEMENT FROM RIGHT, ONLY IN THIS QUESTION
         * WE HAVE TO GET THE FIRST SMALLER FROM LEFT, AND IF THERE ISN'T ONE UPDATE -1, ANOTHER DIFFERENCE IN THIS QUESTION IS THAT
         * WE DON'T HAVE TO CHECK THE RIGHT IN THIS QUESTION UNLIKE NEXT GREATER.
         *
         * HERE WE WILL UPDATE STACK IN DESCENDING ORDER AND IF ANY ELEMENT COMES OUT TO BE SMALLER THAN STACK TOP, WE WILL UPDATE
         * IT TILL ELEMENTS GREATER THAN IT ARE REMOVED.
         */
    }
}
