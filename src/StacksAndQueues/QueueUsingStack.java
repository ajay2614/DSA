package StacksAndQueues;

import java.util.Stack;

public class QueueUsingStack {

    public QueueUsingStack() {}

    /**
     * BRUTE APPROACH
     *
     * Time Complexity: O(N )
     *
     * Space Complexity: O(2N)
     */
//    Stack<Integer> s1 = new Stack<>();
//    Stack<Integer> s2 = new Stack<>();
//
//    public void push(int x) {
//        s1.push(x);
//    }
//
//    public int pop() {
//        int num = -1;
//        while(s1.size() > 0) {
//            if(s1.size() == 1) {
//                num = s1.pop();
//                break;
//            }
//            else {
//                s2.push(s1.pop());
//            }
//        }
//
//        while(!s2.isEmpty()) {
//            s1.push(s2.pop());
//        }
//        return num;
//    }
//
//    public int peek() {
//        int num = -1;
//        while(s1.size() > 0) {
//            if(s1.size() == 1) {
//                num = s1.peek();
//                s2.push(s1.pop());
//            }
//            else {
//                s2.push(s1.pop());
//            }
//        }
//        while(!s2.isEmpty()) {
//            s1.push(s2.pop());
//        }
//        return num;
//    }
//
//    public boolean empty() {
//        return s1.size() == 0;
//    }

    /**
     * Time Complexity: O(1 )
     *
     * Space Complexity: O(2N)
     */
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if(!s2.isEmpty())
            return s2.pop();

        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        return s2.pop();
    }

    public int peek() {
        if(!s2.isEmpty())
            return s2.peek();

        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        return s2.peek();
    }

    public boolean empty() {
        return s1.size() == 0 && s2.size() == 0;
    }

    public static void main(String[] args) {
        /**
         * USING STACK WE HAVE TO MAKE QUEUE
         *
         * BRUTE APPROACH, USE TWO STACKS EVERY TIME POP OR PEEK IS TO OCCUR, TRANSFER ALL THE ELEMENTS FROM STACK 1 TO STACK 2,
         * NOW REMOVE OR GET THE TOP ELEMENT AND TRANSFER BACK TO STACK 1.
         *
         * OPTIMAL APPROACH
         *
         * RATHER THAN TRANSFERRING EVERY TIME WE POP OR PEEK, WHAT WE CAN DO IS WHEN WE POP OR PEEK THEN ONLY TRANSFER IF THE
         * STACK2 IS EMPTY, ELSE SIMPLY GET THE TOP OF STACK
         *
         * EG WE PUSH IN STACK 1 , 1 2 3, NO WE POP AS THE STACK2 IS EMPTY, TRANFER IN THE STACK, 3 2 1 IS NOW WAHT IS IN STACK 2,
         * NOW EVEN IF WE PUSH 4, WE KNOW AS QUEUE IS FIFO, STACK 2 HAVING 3 2 1, STILL OUT ANS WOULD BE 1, SO SIMPLY GET STACK2
         * TOP.
         *
         */
    }
}
