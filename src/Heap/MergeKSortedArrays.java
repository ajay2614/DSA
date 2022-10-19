package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Element {
    int row;
    int value;
    int index;
    int size;

    public Element(int row, int value, int index, int size) {
        this.row = row;
        this.value = value;
        this.index = index;
        this.size = size;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
public class MergeKSortedArrays {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        PriorityQueue<Element> priorityQueue = new PriorityQueue<>((o1,o2) -> {
            if(o1.getValue() > o2.getValue())
                return 1;
            else if(o1.getValue() < o2.getValue())
                return -1;
            return 0;
        });

        for (int i=0;i<k;i++) {
            priorityQueue.add(new Element(i, kArrays.get(i).get(0), 0, kArrays.get(i).size()));
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!priorityQueue.isEmpty()) {
            Element e = priorityQueue.poll();
            ans.add(e.getValue());

            if(e.getIndex() < e.getSize()-1) {
                int row = e.getRow();
                int ind = e.getIndex()+1;
                int val = kArrays.get(row).get(ind);

                priorityQueue.add(new Element(row,val,ind,e.getSize()));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        /**
         *
         * BREAKDOWN
         *
         * IN THIS QUESTION WE ARE GIVEN K SORTED ARRAYS AND WE HAVE TO SORT THEM, LIKE IN THE MERGE SORT WE USE POINTER APPROACH
         * SO IF IN SOME WAY WE CAN GET TO STORE POINTERS AND VALUES IN SORTED ORDER, WE WILL BE ABLE TO GET THE RESULTING
         * ARRAY LIST
         *
         *
         * APPROACH
         *
         * WHAT WE WILL DO IN THIS QUESTION IS DEFINE A CLASS ELEMENT, AND HAVE THE VARIABLES ROW, IND, VALUE AND SIZE
         *
         * IN OUR METHOD WE WILL DEFINE A PRIORITY QUEUE OF ELEMENT TYPE, WHICH WILL SORT BASED ON THE VALUES,
         * RUN A FOR LOOP FROM I TO K, FOR K LISTS AND STORE THE VALUE OF 0TH INDEX IN THEM.
         *
         * AFTER THIS POP THE FIRST ELEMENT, IN THIS WAY THE SMALLES VALUE ELEMENT FROM ALL THE K ELEMENTS WILL BE POPPED
         * AND HENCE WE CAN ADD THAT VALUE TO ARRAY LIST, SINCE THE LISTS WERE SORTED AND PQ WOULD SORT ALL THE 0TH ELEMENTS
         * WE ARE BOUND TO GET THE SMALLEST ELEMENT HERE.
         *
         * AFTER THIS ADD CHECK IF THE ELEMENT HAS NEXT INDEX, MEANING IT ISN'T ON LAST INDEX, INDEX < SIZE-1
         *
         * IF IT IS, GET THE ELEMENT FOR NEXT INDEX AND PLACE IT IN PRIORITY QUEUE, FOR EG
         *
         * 1 2 5 AND 3 4 ARE ARRAYS, 1 AND 3 ARE ADDED IN NEXT STEP, 1 GETS POPPED CHECKS FOR ENXT ELEMENT WHICH IS 2, AND PLACE
         * IT IN PQ, AFTER WORDS NEXT SMALLEST GETS POPPED WHICH IS 2, AND NOW 5 WILL GET ADDED AND THEN 3 WILL GET POPPED AND
         * THEN 4 AND 5. SINCE PQ WILL ALWAYS SORT BASED ON VALUE, WE ARE BOUND TO GET SMALLEST VAL ELEMENT ON TOP
         *
         * DO THIS TILL Q IS NOT EMPTY.
         *
         */
        int []A = { 1,5,4,2 };
        int []B = { 7,8,3,6 };
        Arrays.sort(A);
        Arrays.sort(B);
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        Arrays.stream(A).forEach(o -> a.add(o));
        Arrays.stream(B).forEach(o -> b.add(o));

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        arrayList.add(a);
        arrayList.add(b);
        mergeKSortedArrays(arrayList, 2);
    }
}
