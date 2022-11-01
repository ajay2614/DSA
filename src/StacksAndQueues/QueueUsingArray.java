package StacksAndQueues;

public class QueueUsingArray {
    int arr[] = new int[1000000];
    int rear = 0;
    int front = 0;
    QueueUsingArray() {}

    boolean isEmpty() {
        if(front == rear)
            return true;
        return false;
    }

    void enqueue(int data) {
        arr[rear++] = data;
    }

    int dequeue() {
        if(front == rear)
            return -1;
        return arr[front++];
    }

    int front() {
        if(front == rear)
            return -1;
        return arr[front];
    }

    /**
     * BASIC FUNCTIONS OF QUEUE, USED FRONT AND REAR POINTER, IF FRONT == REAR MEANS QUEUE IS EMPTY, THIS IS BECAUSE
     * EVERYTIME WE WILL ADD AND ELEMENT REAR WILL MOVE BY 1 POINTER AND REAR - FRONT WOULD BE THE SIZE
     *
     * EG ON ADDING 1 2, FRONT WOULD BE AT 0 AND REAR WOULD BE AT 2, SO AS REAR - FRONT IF 0 MEANS THE SIZE WILL BE 0.
     */
}
