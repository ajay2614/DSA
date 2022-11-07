package StacksAndQueues;

import java.util.Stack;

class Pair {
    int val;
    int min;

    Pair(int val, int min) {
        this.val = val;
        this.min = min;
    }
}
public class MinStack {

    /**
     * BRUTE APPROACH
     * Time Complexity: O(1)
     *
     * Space Complexity: O(2N)
     */
//    Stack<Pair> stack = new Stack<>();
//
//    public MinStack() {
//
//    }
//
//    public void push(int val) {
//        if(stack.isEmpty())
//            stack.push(new Pair(val, val));
//        else {
//            int min = stack.peek().min;
//            min = Math.min(min, val);
//            stack.push(new Pair(val, min));
//        }
//    }
//
//    public void pop() {
//        stack.pop();
//    }
//
//    public int top() {
//        return stack.peek().val;
//    }
//
//    public int getMin() {
//        return stack.peek().min;
//    }

    /**
     * Time Complexity: O(1)
     *
     * Space Complexity: O(N)
     */

    Stack<Long> st = new Stack<>();
    long min = (long) Math.pow(10,10);
    public MinStack() {}

    public void push(int val) {
        if(st.isEmpty()) {
            min = (long) val;
            st.push((long) val);
        }
        else if(val > min) {
            st.push((long) val);
        }
        else {
            long lastMin = min;
            long newVal = 2 * (long) val - lastMin;
            st.push(newVal);
            min = (long) val;
        }
    }

    public void pop() {
        if(st.peek() < min) {
            long topVal = st.peek();
            long lastMin = 2 * min - topVal;
            /**
             AS WE KNOW
             TOP VAL IS (2 * VAL) - LASTMIN
             AND VAL WAS UPDATED AS MIN
             SO THE EQUATION CAN ALSO BE WRITTEN AS 2 * MIN - 2 * MIN + LASTMIN
             */

            st.pop();
            min = lastMin;
        }
        else {
            st.pop();
        }
    }

    public int top() {
        if(st.peek() < min) {
            return (int) min;
            /**
             WHY THIS WILL WORK
             BECAUSE IF THE CURRENT MIN WAS UPDATED BY THE LAST ELEMENT PUSHED,
             THEN THIS EQUATION WILL ALWAYS BE TRUE

             BECAUSE MIN < LASTMIN, SO IT CAN BE WRITTEN AS MIN - LASTMIN < 0
             , ADDING MIN TO BOTH SIDES 2 * MIN - LASTMIN < MIN, AND WE KNOW
             STACK TOP IS BEING UPDATED AS 2 * MIN - LASTMIN, WHILE PUSHING
             IF VAL WAS SMALLER THAN MIN.
             */
        }
        return st.peek().intValue();
    }

    public int getMin() {
        return (int) min;
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION GIVEN A STACK, ALONG WITH THE OPERATIONS ON STACK WE NEED TO PERFORM ONE MORE OPERATION, WHICH IS
         * TO RETURN MIN VALUE IN THE STACK.
         *
         * BRUTE APPROACH
         *
         * THE BRUTE APPROACH IS ALMOST AS GOOD AS OPTIMAL APPROACH, JUST MAKE A CLASS PAIR, WHICH WILL HAVE VALUE AND MIN
         * IF THE STACK IS EMPTY ADD INPUT VAL AS THE VAL AND MIN, IN PAIR
         *
         * IF THE STACK IS NOT EMPTY, CHECK FOR THE MIN FROM THE STACK TOP, IF IT IS SMALLER THAN VAL THEN ADD IT AS MIN,
         * ELSE ADD VAL AS VALUE AND MINIMUM.
         *
         * OPTIMAL APPROACH
         *
         * IN THIS WE WILL DO FEW THINGS TO MAKE SURE WE CAN :
         * EASILY HAVE THE NEW MIN, IF MIN VALUE COMES AS INPUT
         * OR IF WE HAVE TO POP THEN GET THE LAST MIN IF MIN ELEMENT WAS POPPED
         *
         * OPERATIONS
         *
         * IF THE STACK IS EMPTY THEN SIMPLY INPUT THE VAL AND HAVE MIN VARIABLE AS VAL,
         * ELSE IF THE VAL IS LARGER THAN MIN, THEN SIMPLY ADD THE VAL ON TOP, NO NEED TO CHANGE AS THIS CANNOT BE OUR MIN
         * ELSE IF THE INPUT VAL IS SMALLER THAN MIN, THEN PUSH(2 * VAL - CURRENTMIN) IN STACK, AND UPDATE MIN AS VALUE
         * THIS IS DONE BECAUSE IF WE NEED TO CHECK WHILE POPPING THAT WHETHER THE TOP ELEMENT IS THE MIN, WE CAN CHECK IT BY
         * CHECKING WHETHER 2 * VAL - CURRENTMIN (STACK TOP) < MIN, WHY THIS WILL ALWAYS BE TRUE IF THE LAST ELEMENT WAS INDEED
         * MIN, LETS SAY CURRENT MIN IS -2, AND NEW INPUT IS -3, AS VAL < MIN, VAL - MIN < 0, NOW ADDING VALUE TO BOTH SIDES
         * 2 * VAL - MIN < VAL, SO IT WILL ALWAYS BE TRUE FOR MIN, THIS IS ALSO DONE AS WHEN WE HAVE TO POP WE KNOW THE MIN ELEMENT
         * HAS POPPED SO TO GET THE CURRENT MIN, OR WHAT WAS THE MIN BEFORE POPPING THE ELEMENT,
         *
         * WE CAN GET THAT BY 2 * CURRENTMIN - VAL(STACK TOP) = THIS WILL GIVE US OUR PREVMIN, HOW?
         * AS WE KNOW VAL WHICH WE HAD PUSHED WAS 2 * VAL - MIN, AS VAL WOULD GO ON TO BECOME OUR CURRENT MIN, WE CAN
         * COMBINE BOTH EQ AND WRITE AS 2 * CURRENTMIN - 2 * CURRENT MIN + LASMIN, SO LASTMIN IS LEFT HENCE WE CAN GET THIS
         * IF WE HAVE TO POP THE ELEMENT.
         *
         * WHEN WE HAVE TO GET THE TOP AND STACKTOP IS SMALLER THEN MIN, THEN IT MEANS MIN WAS INDEED THE LAST VALUE, HENCE SIMPLY
         * RETURN MIN.
         */
    }
}
