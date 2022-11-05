package StacksAndQueues;

import java.util.Stack;

class StockPair {
    int price;
    int span;

    StockPair(int price, int span) {
        this.price = price;
        this.span = span;
    }
}
public class OnlineStockPlan {
    Stack<StockPair> st = new Stack<>();
    public OnlineStockPlan() {}

    public int next(int price) {
        int ans = 1;
        while(!st.isEmpty() && st.peek().price <= price) {
            StockPair p = st.pop();
            ans += p.span;
        }
        st.push(new StockPair(price, ans));
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {100,80,60,70,60,75,85};
        /**
         * IN THIS QUESTION WE ARE GIVEN AN ARRAY, HAVING STOCKS, AT EVERY STAGE WE NEED TO FIND THE SPAN, SPAN HERE IS TOTAL OF
         * ELEMENTS INCLUDING ITSELF + ALL SMALLER ELEMENTS IN STOCK
         *
         * FOR EG FOR ABOVE ARRAY
         * stockSpanner.next(100); // return 1, no one smaller than 100
         * stockSpanner.next(80);  // return 1, no one smaller than 80
         * stockSpanner.next(60);  // return 1, no one smaller than 60
         * stockSpanner.next(70);  // return 2, 60 smaller than 70
         * stockSpanner.next(60);  // return 1, no one smaller than 60
         * stockSpanner.next(75);  // return 4, 70, 60, 60 smaller than 75
         * stockSpanner.next(85);  // return 6, 75,70,60,60,80 smaller than 85
         *
         * APPROACH
         *
         * SINCE WE NEED TO FIND AT EVERY STAGE THE SPAN, WE CANNOT USE SOMETHING LIKE ARRAY LIST AS WE HAVE TO RETURN INT VALUE
         *
         * THE WAY WE CAN SOLVE THIS IS MAKING A PAIR, OF PRICE AND ITS SPAN, AT EVERY STAGE IF STACK TOP HAS SMALLER ELEMENT
         * THEN POP IT AND GET ITS SPAN VALUE, AFTER POPPING ALL SMALLER ELEMENTS PUSH THE CURRENT ELEMENT WITH ITS CURRENT
         * SPAN, THIS WAY WE CAN KEEP TRACK OF EVERY PREVIOUSLY POPPED AND INCLUDE IT IN ANS.
         *
         *          * stockSpanner.next(100); // return 1, STACK HAS 100 WITH 1
         *          * stockSpanner.next(80);  // return 1, STACK HAS 80 WTIH 1
         *          * stockSpanner.next(60);  // return 1, STACK HAS 60 WITH 1
         *          * stockSpanner.next(70);  // return 2, STACK HAS 60 POPPED AND 70 WITH 2
         *          * stockSpanner.next(60);  // return 1, STACK HAS 60 WITH 1
         *          * stockSpanner.next(75);  // return 4, STACK HAS 60 AND 70 POPPED, 1 + 2 + 1(ITSELF) ADDED IN SPAN
         *          * stockSpanner.next(85);  // return 6, STACK HAS 75 WITH 4 POPPED, 80 WITH 1 POPPED
         *
         *
         * SINCE WE ARE ALWAYS FOLLOWING ASCENDING ORDER IN A WAY IN STACK, IT IS SURE THAT IF TOP IS BIGGER IT WON'T BE HAVING
         * SMALLER UNDER IT.
         */
    }
}
