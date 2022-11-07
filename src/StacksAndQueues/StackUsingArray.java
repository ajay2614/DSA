package StacksAndQueues;

public class StackUsingArray {
    /**
     * Time Complexity: O(N)
     *
     * Space Complexity: O(N)
     */
    int arr[];
    StackUsingArray(int length) {
        arr = new int[length];
    }
    int top = 0;
    void push(int num) {
        if(top < arr.length)
            arr[top++] = num;
    }
    int pop() {
        if(top > 0) {
            top--;
            return arr[top];
        }
        return -1;
    }
    int top() {
        if(top > 0) {
            return arr[top-1];
        }
        return -1;
    }
    int isEmpty() {
        // Write your code here.
        if(top == 0)
            return 1;
        return 0;
    }
    int isFull() {
        // Write your code here.
        if(top == arr.length)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        /**
         * SIMPLE IMPLEMENTATION OF THE STACK USING AN ARRAY, WHENEVER THE ELEMENT COMES PUSH, AND WHENEVER THE ELEMENT IS TO
         * BE REMOVED REMOVE ARR[--TOP], FOR RETURNING TOP GET ARR[TOP-1], AS TOP WILL ALWAYS HAVE +1 VALUE THAN THE LAST INDEX.
         */
        StackUsingArray stackUsingArray = new StackUsingArray(3);
        stackUsingArray.push(1);
        stackUsingArray.push(2);
        System.out.println(stackUsingArray.isFull());
        stackUsingArray.push(4);
        System.out.println(stackUsingArray.isFull());
    }
}
