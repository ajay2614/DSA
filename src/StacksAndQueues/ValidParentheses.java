package StacksAndQueues;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        int n = s.length();

        if(n % 2 != 0)
            return false;

        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++) {

            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(')
                st.push(s.charAt(i));
            else {
                if(st.size() == 0)
                    return false;
                char c = st.pop();
                if(s.charAt(i) == '}' && c == '{')
                    continue;
                else if(s.charAt(i) == ']' && c == '[')
                    continue;
                else if(s.charAt(i) == ')' && c == '(')
                    continue;
                else
                    return false;
            }
        }
        return st.size() == 0;
    }
    public static void main(String[] args) {
        isValid("{[]}");
    }

    /**
     * THE QUESTION WILL GIVE US SOMETHING LIKE ABOVE WE HAVE TO MAKE SURE THESE ARE VALID PARENTHESES, FOR EVERY OPENING TAG
     * CLOSING TAG MUST BE THERE, TO CHECK THIS WE CAN SIMPLY USE A STACK, EVERY TIME WE WILL GET A OPENING TAG WE WILL ADD
     * IT IN THE STACK, AND EVERYTIME WE WILL GET A CLOSING TAG WE WILL CHECK FOR TWO THINGS
     *
     * WHETHER THE POPPED CHAR MATCHES THE TAG, MEANING IF CLOSING TAG IS ] THEN OPENING TAG MUST BE [, OTHERWISE RETURN FALSE
     * OR IF THE STACK IS EMPTY MEANING IF INPUT IS SOMETHING LIKE )[] THEN ALSO RETURN FALSE, IN THE END IF STACK SIZE IS 0
     * MEANING RETURN TRUE, ELSE MEANS THAT AN OPENING TAG IS LEFT SO RETURN FALSE.
     *
     * HOW THIS WILL ALWAYS WORK SUPPOSE FOR ABOVE WE WILL PUSH {[ FIRST, WHEN ] THIS COMES THEN WE ARE SURE TO GET [ ON OPENING
     * TAG HENCE THIS SOLUTION WILL ALWAYS WORK.
     */
}
