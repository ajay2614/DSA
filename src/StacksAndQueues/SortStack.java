package StacksAndQueues;

import java.util.Stack;

public class SortStack {
    public static void sortStack1stApproach(Stack<Integer> stack) {
        Stack<Integer> st = new Stack<>();

        while(!stack.isEmpty()) {
            int val = stack.pop();

            while(!st.isEmpty() && st.peek() < val) {
                stack.push(st.pop());
            }
            st.push(val);
        }
        while(!st.isEmpty()) {
            stack.push(st.pop());
        }
    }
    public static void sortStackRecursive(Stack<Integer> stack) {
        if(stack.isEmpty())
            return;
        int val = stack.pop();
        sortStackRecursive(stack);
        recursion(stack, val);
    }

    public static void recursion(Stack<Integer> stack, int val) {
        if(stack.isEmpty() || val > stack.peek()) {
            stack.push(val);
            return;
        }
        else {
            int top = stack.pop();
            recursion(stack, val);
            stack.push(top);
        }

    }

    public static void main(String[] args) {
        /**
         * WE HAVE TO SORT THE GIVEN STACK IN THIS QUESTION
         *
         * 1 ST APPROACH
         *
         * USE ANOTHER STACK, RUN TILL STACK 1 IS EMPTY, EVERYTIME WE GET A VALUE FROM STACK 1, COMPARE WHETHER STACK
         * 2 TOP IS SMALLER, IF IT IS SMALLER POP AND PUSH BACK IN STACK 1, THE ELEMENTS THAT ARE SMALLER THAN THAT PARTICULAR
         * ELEMENT, PUSH THAT PARTICULAR ELEMENT IN STACK 2, IN THIS WAY WE WILL GET STACK 2 IN ASCENDING ORDER, SIMPLY
         * TRANSFER FROM STACK 2 TO 1 THEN.
         *
         * 2ND APPROACH
         *
         * IN THIS APPROACH WE WILL USE RECURSION, WE WILL RUN RECRUSION TILL STACK IS EMPTY, ONCE IT IS EMPTY
         * THEN RUN A METHOD THAT WILL COMPARE THE POPPED ELEMENT WITH THE ELEMENT IN STACK, IF THE POPPED ELEMENT
         * IS SMALLER THAN STACK TOP THEN, THEN POP THE STACK TOP AND CALL THE SAME METHOD FOR THE SAME ELEMENT,
         *
         * SO IN THIS WAY EVERYTIME THERE IS AN OUT OF ORDER ELEMENT, BIGGER ELEMENTS WILL KEEP GETTING POPPED TILL
         * THAT ELEMENT IS PLACED SUCCESSFULLY IN THE STACK
         *
         * FOR EG FOR 1 4 3 8, THE STACK WILL BE EMPTY, THEN 8 WILL BE IN STACK, THEN COMPARING WITH 3, 8 WILL GET POPPED
         * AND THEN 3 WILL BE IN STACK THEN WHEN IT BACKTRACKS 8 WILL BE STACK TOP, THEN WHEN 4 COMES, 8 WILL GET POPPED,
         * AND ON BACKTRACK IT WILL BE 8 4 3, THEN FOR 1 SAME PROCESS WILL HAPPEN, 8 WILL GET POPPED THEN 4 AND 3 AND STACK IS
         * EMPTY AND 1 WILL BE PUSHED IN STACK THEN ON BACKTRACK 3, 4 AND 8 WILL BE PUSHED THEREFORE SORTING STACK IN DESCENDING
         * ORDER.
         */
    }
}
