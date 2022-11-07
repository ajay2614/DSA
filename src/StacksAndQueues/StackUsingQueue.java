package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    public StackUsingQueue() {

    }

    /**
        BRUTE APPROACH
        Time Complexity: O(N)

        Space Complexity: O(2N)
     */
//    Queue<Integer> q1 = new LinkedList<>();
//    Queue<Integer> q2 = new LinkedList<>();
//
//
//    public void push(int x) {
//        q1.add(x);
//    }
//
//    public int pop() {
//        int num = 0;
//        while(q1.size() > 0) {
//            if(q1.size() == 1) {
//                num = q1.poll();
//            }
//            else {
//                q2.add(q1.poll());
//            }
//        }
//
//        while(!q2.isEmpty()) {
//            q1.add(q2.poll());
//        }
//        return num;
//    }
//
//    public int top() {
//        int top = -1;
//        while(q1.size() > 0) {
//            if(q1.size() == 1) {
//                top = q1.peek();
//                q2.add(q1.poll());
//            }
//
//            else {
//                q2.add(q1.poll());
//            }
//        }
//
//        while(!q2.isEmpty()) {
//            q1.add(q2.poll());
//        }
//        return top;
//    }
//
//    public boolean empty() {
//        if(q1.size() == 0)
//            return true;
//        return false;
//    }

    /**
     * Time Complexity: O(N)
     *
     * Space Complexity: O(N)
     */
    Queue<Integer> q1 = new LinkedList<>();

    public void push(int x) {
        q1.add(x);

        int i = q1.size();
        i -= 1;
        while(i > 0) {
            q1.add(q1.poll());
            i--;
        }
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.size() == 0;
    }

    public static void main(String[] args) {
        /**
         * WE HAVE TO MAKE A STACK USING QUEUES,
         *
         * BRUTE APPROACH,
         *
         * FOR THE BRUTE APPROACH USE TWO QUEUES, SIMPLE PUSH IN FIRST QUEUE, AND EVERYTIME WE HAVE TO POP KEEP TRANSFERRING
         * FROM Q1 TO Q2 TILL Q1 SIZE IS 1, THE IF IT IS POP THEN SIMPLY REMOVE IT OR ELSE GET THAT ELEMENT AND THEN TRANSFER IT
         * TO Q2, NOW TRANSFER BACK IN Q1. WHY WE NOT USED SAME APPROACH LIKE Q USING STACK, AND TRANSFERRED ENTIRELY AND GET TOP
         * AS, Q1 TO Q2 WOULD HAVE BEEN JUST A DEEPCOPY OF Q1, SO IN ORDER TO GET THE LAST ELEMENT ON FIRST AND THEN POLL IT
         * WE FOLLOWED THESE STEPS.
         *
         * OPTIMAL APPROACH
         *
         * RATHER THAN USING 2 QUEUES, HAVE A SINGLE QUEUE, EVERY TIME WE PUSH, RUN A WHILE LOOP AND AND POP THE FIRST ELEMENT AND
         * PLACE IT AT LAST, RUN THIS FOR Q.SIZE-1
         *
         * SO WITH THIS WHENEVER WE HAVE TO POP OR PEEK, WE WILL AUTOMATICALLY HAVE THE LATEST ELEMENT ON THE FIRST,
         *
         * FOR EG WE ADD 1 TO Q, THEN WHEN ADD 2, REMOVE 1 AND ADD IT BACK, NOW IF WE ADD 3, THEN ADD REMOVE 2 AND ADD BACK AND
         * REMOVE 1 AND ADD BACK, SO THE Q WOULD BE 3 2 1, SO IF WE HAVE TO POP WE WILL GET 3 WHICH WAS THE LAST ELEMENT.
         */
        StackUsingQueue stackUsingQueue = new StackUsingQueue();
        stackUsingQueue.push(1);
        stackUsingQueue.push(2);
        System.out.println(stackUsingQueue.top());
    }
}
